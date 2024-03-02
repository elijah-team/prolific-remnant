/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_c;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.ErrSink;
import tripleo.elijah.lang.*;
import tripleo.elijah.lang.types.OS_FuncExprType;
import tripleo.elijah.lang2.*;
import tripleo.elijah.nextgen.model.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah.util.*;
import tripleo.elijah.work.*;
import tripleo.elijah_prolific.gen_c.GetAssignmentValue;
import tripleo.util.buffer.Buffer;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created 10/8/20 7:13 AM
 */
public class GenerateC implements CodeGenerator, GenerateFiles {
	private static final String  PHASE = "GenerateC";
	final                ErrSink errSink;
	private final        ElLog   LOG;

	public GenerateC(final @NotNull OutputFileFactoryParams p) {
		errSink = p.getErrSink();
		LOG     = new ElLog(p.getModFileName(), p.getVerbosity(), PHASE);
		//
		p.addLog(LOG);
	}

	public static @NotNull String getRealTargetName(final BaseGeneratedFunction gf, final @NotNull VariableTableEntry varTableEntry) {
		final String vte_name = varTableEntry.getName();
		if (varTableEntry.vtt == VariableTableType.TEMP) {
			if (varTableEntry.getName() == null) {
				return "vt" + varTableEntry.tempNum;
			} else {
				return "vt" + varTableEntry.getName();
			}
		} else if (varTableEntry.vtt == VariableTableType.ARG) {
			return "va" + vte_name;
		} else if (SpecialVariables.contains(vte_name)) {
			return SpecialVariables.get(vte_name);
		} else if (isValue(gf, vte_name)) {
			return "vsc->vsv";
		} else {
			return Emit.emit("/*879*/") + "vv" + vte_name;
		}
	}

	private static boolean isValue(final BaseGeneratedFunction gf, final @NotNull String name) {
		if (!name.equals("Value")) return false;
		//
		final FunctionDef fd = (FunctionDef) gf.getFD();
		switch (fd.getSpecies()) {
		case REG_FUN:
		case DEF_FUN:
			if (!(fd.getParent() instanceof ClassStatement)) return false;
			for (final AnnotationPart anno : ((ClassStatement) fd.getParent()).annotationIterable()) {
				if (anno.annoClass().equals(Helpers.string_to_qualident("Primitive"))) {
					return true;
				}
			}
			return false;
		case PROP_GET:
		case PROP_SET:
			return true;
		default:
			throw new IllegalStateException("Unexpected value: " + fd.getSpecies());
		}
	}

	public GenerateResult generateCode(final Collection<GeneratedNode> lgn, final WorkManager wm) {
		final GenerateResult gr = new GenerateResult();

		for (final GeneratedNode generatedNode : lgn) {
			if (generatedNode instanceof final GeneratedFunction generatedFunction) {
				final WorkList wl = new WorkList();
				generate_function(generatedFunction, gr, wl);
				if (!wl.isEmpty())
					wm.addJobs(wl);
			} else if (generatedNode instanceof final GeneratedContainerNC containerNC) {
				containerNC.generateCode(this, gr);
			} else if (generatedNode instanceof final GeneratedConstructor generatedConstructor) {
				final WorkList wl = new WorkList();
				generate_constructor(generatedConstructor, gr, wl);
				if (!wl.isEmpty())
					wm.addJobs(wl);
			}
		}

		return gr;
	}

	@NotNull
	public String getTypeName(final GeneratedNode aNode) {
		if (aNode instanceof GeneratedClass)
			return getTypeName((GeneratedClass) aNode);
		if (aNode instanceof GeneratedNamespace)
			return getTypeName((GeneratedNamespace) aNode);
		throw new IllegalStateException("Must be class or namespace.");
	}

	String getTypeName(@NotNull final GeneratedClass aGeneratedClass) {
		return GetTypeName.forGenClass(aGeneratedClass);
	}

	String getTypeName(@NotNull final GeneratedNamespace aGeneratedNamespace) {
		return GetTypeName.forGenNamespace(aGeneratedNamespace);
	}

	public void generate_function(final GeneratedFunction aGeneratedFunction, final GenerateResult gr, final WorkList wl) {
		generateCodeForMethod(aGeneratedFunction, gr, wl);
		for (final IdentTableEntry identTableEntry : aGeneratedFunction.idte_list) {
			if (identTableEntry.isResolved()) {
				final GeneratedNode x = identTableEntry.resolvedType();

				if (x instanceof GeneratedClass) {
					generate_class((GeneratedClass) x, gr);
				} else if (x instanceof GeneratedFunction) {
					wl.addJob(new WlGenerateFunctionC((GeneratedFunction) x, gr, wl, this));
				} else {
					LOG.err(x.toString());
					throw new NotImplementedException();
				}
			}
		}
		for (final ProcTableEntry pte : aGeneratedFunction.prte_list) {
//			ClassInvocation ci = pte.getClassInvocation();
			final FunctionInvocation fi = pte.getFunctionInvocation();
			if (fi == null) {
				// TODO constructor
				final int y = 2;
/*
				if (pte.getClassInvocation() == null)
					assert pte.getStatus() == BaseTableEntry.Status.UNKNOWN;
*/
			} else {
				final BaseGeneratedFunction gf = fi.getGenerated();
				if (gf != null) {
					wl.addJob(new WlGenerateFunctionC(gf, gr, wl, this));
				}
			}
		}
	}

	public void generate_constructor(final GeneratedConstructor aGeneratedConstructor, final GenerateResult gr, final WorkList wl) {
		generateCodeForConstructor(aGeneratedConstructor, gr, wl);
		for (final IdentTableEntry identTableEntry : aGeneratedConstructor.idte_list) {
			if (identTableEntry.isResolved()) {
				final GeneratedNode x = identTableEntry.resolvedType();

				if (x instanceof GeneratedClass) {
					generate_class((GeneratedClass) x, gr);
				} else if (x instanceof GeneratedFunction) {
					wl.addJob(new WlGenerateFunctionC((GeneratedFunction) x, gr, wl, this));
				} else {
					LOG.err(x.toString());
					throw new NotImplementedException();
				}
			}
		}
		for (final ProcTableEntry pte : aGeneratedConstructor.prte_list) {
//			ClassInvocation ci = pte.getClassInvocation();
			final FunctionInvocation fi = pte.getFunctionInvocation();
			if (fi == null) {
				// TODO constructor
				final int y = 2;
			} else {
				final BaseGeneratedFunction gf = fi.getGenerated();
				if (gf != null) {
					wl.addJob(new WlGenerateFunctionC(gf, gr, wl, this));
				}
			}
		}
	}

	@Override
	public void generate_namespace(final GeneratedNamespace x, final GenerateResult gr) {
		if (x.generatedAlready) return;
		// TODO do we need `self' parameters for namespace?
		final BufferTabbedOutputStream tosHdr = new BufferTabbedOutputStream();
		final BufferTabbedOutputStream tos    = new BufferTabbedOutputStream();
		try {
			if (x.varTable.size() > 0) {
				tosHdr.put_string_ln("typedef struct {");
				tosHdr.incr_tabs();
//				tosHdr.put_string_ln("int _tag;");
				for (final GeneratedNamespace.VarTableEntry o : x.varTable) {
					final String typeName = getTypeNameGNCForVarTableEntry(o);

					tosHdr.put_string_ln(String.format("%s* vm%s;", o.varType == null ? "void " : typeName, o.nameToken));
				}

				final String class_name = getTypeName(x);
				final int    class_code = x.getCode();

				tosHdr.dec_tabs();
				tosHdr.put_string_ln("");
				tosHdr.put_string_ln(String.format("} %s; // namespace `%s'", class_name, x.getName()));
				// TODO "instance" namespaces
				tosHdr.put_string_ln("");
				tosHdr.put_string_ln(String.format("Z%d zN%s_instance; // namespace `%s'", class_code, class_name, x.getName()));
				tosHdr.put_string_ln("");

				tosHdr.put_string_ln("");
				tosHdr.put_string_ln("");
				tos.put_string_ln(String.format("%s* ZN%d() {", class_name, class_code));
				tos.incr_tabs();
				// TODO multiple calls of namespace function (need if/else statement)
				tos.put_string_ln(String.format("%s* R = GC_malloc(sizeof(%s));", class_name, class_name));
//				tos.put_string_ln(String.format("R->_tag = %d;", class_code));
				for (final GeneratedNamespace.VarTableEntry o : x.varTable) {
//					final String typeName = getTypeNameForVarTableEntry(o);
					tosHdr.put_string_ln(String.format("R->vm%s = 0;", o.nameToken));
				}
				tos.put_string_ln("");
				tos.put_string_ln(String.format("zN%s_instance = R;", class_name));
				tos.put_string_ln("return R;");
				tos.dec_tabs();
				tos.put_string_ln(String.format("} // namespace `%s'", x.getName()));
				tos.put_string_ln("");
				tos.flush();
			}
		} finally {
			tos.close();
			tosHdr.close();
			if (x.varTable.size() > 0) { // TODO should we let this through?
				final Buffer buf = tos.getBuffer();
//				LOG.info(buf.getText());
				gr.addNamespace(GenerateResult.TY.IMPL, x, buf, x.module().getLsp());
				final Buffer buf2 = tosHdr.getBuffer();
//				LOG.info(buf2.getText());
				gr.addNamespace(GenerateResult.TY.HEADER, x, buf2, x.module().getLsp());
			}
		}
		x.generatedAlready = true;
	}

	@Override
	public void forNode(final SM_Node aNode) {
		final int y = 2;
		if (aNode instanceof final SM_ClassDeclaration classDecl) {
			//			return classDecl;
		}
//		return null;
	}

	@NotNull
	public String getTypeNameGNCForVarTableEntry(final GeneratedContainer.VarTableEntry o) {
		final String typeName;
		if (o.resolvedType() != null) {
			final GeneratedNode xx = o.resolvedType();
			if (xx instanceof GeneratedClass) {
				typeName = getTypeName((GeneratedClass) xx);
			} else if (xx instanceof GeneratedNamespace) {
				typeName = getTypeName((GeneratedNamespace) xx);
			} else
				throw new NotImplementedException();
		} else {
			if (o.varType != null)
				typeName = getTypeName(o.varType);
			else
				typeName = "void*/*null*/";
		}
		return typeName;
	}

	public GenerateResult resultsFromNodes(final List<GeneratedNode> aNodes, final WorkManager wm) {
		final GenerateC ggc = this;

		final GenerateResult gr2 = new GenerateResult();

		for (final GeneratedNode generatedNode : aNodes) {
//			if (generatedNode.module() != mod) continue; // README curious

			if (generatedNode instanceof final GeneratedContainerNC nc) {

				nc.generateCode(ggc, gr2);
				final @NotNull Collection<GeneratedNode> gn1 = (nc.functionMap.values()).stream().map(x -> (GeneratedNode) x).collect(Collectors.toList());
				final GenerateResult                     gr3 = ggc.generateCode(gn1, wm);
				gr2.results().addAll(gr3.results());
				final @NotNull Collection<GeneratedNode> gn2 = (nc.classMap.values()).stream().map(x -> (GeneratedNode) x).collect(Collectors.toList());
				final GenerateResult                     gr4 = ggc.generateCode(gn2, wm);
				gr2.results().addAll(gr4.results());
			} else {
				SimplePrintLoggerToRemoveSoon.println2("2009 " + generatedNode.getClass().getName());
			}
		}

		return gr2;
	}

	private void generateCodeForMethod(final BaseGeneratedFunction gf, final GenerateResult gr, final WorkList aWorkList) {
		if (gf.getFD() == null) return;
		final Generate_Code_For_Method gcfm = new Generate_Code_For_Method(this, LOG);
		gcfm.generateCodeForMethod(gf, gr, aWorkList);
	}

	private void generateCodeForConstructor(final GeneratedConstructor gf, final GenerateResult gr, final WorkList aWorkList) {
		if (gf.getFD() == null) return;
		final Generate_Code_For_Method gcfm = new Generate_Code_For_Method(this, LOG);
		gcfm.generateCodeForConstructor(gf, gr, aWorkList);
	}

	String getTypeNameForGenClass(@NotNull final GeneratedNode aGenClass) {
		return GetTypeName.getTypeNameForGenClass(aGenClass);
	}

	String getTypeNameForVariableEntry(@NotNull final VariableTableEntry input) {
		return GetTypeName.forVTE(input);
	}

	String getTypeName(@NotNull final TypeTableEntry tte) {
		return GetTypeName.forTypeTableEntry(tte);
	}

	@Override
	public void generate_class(final GeneratedClass x, final GenerateResult gr) {
		if (x.generatedAlready) return;
		switch (x.getKlass().getType()) {
		// Don't generate class definition for these three
		case INTERFACE:
		case SIGNATURE:
		case ABSTRACT:
			return;
		}
		final CClassDecl decl = new CClassDecl(x);
		decl.evaluatePrimitive();
		final BufferTabbedOutputStream tosHdr = new BufferTabbedOutputStream();
		final BufferTabbedOutputStream tos    = new BufferTabbedOutputStream();
		try {
			tosHdr.put_string_ln("typedef struct {");
			tosHdr.incr_tabs();
			tosHdr.put_string_ln("int _tag;");
			if (!decl.prim) {
				for (final GeneratedClass.VarTableEntry o : x.varTable) {
					final String typeName = getTypeNameGNCForVarTableEntry(o);
					tosHdr.put_string_ln(String.format("%s vm%s;", typeName, o.nameToken));
				}
			} else {
				tosHdr.put_string_ln(String.format("%s vsv;", decl.prim_decl));
			}

			final String class_name = getTypeName(x);
			final int    class_code = x.getCode();

			tosHdr.dec_tabs();
			tosHdr.put_string_ln("");
//			tosHdr.put_string_ln(String.format("} %s;", class_name));
			tosHdr.put_string_ln(String.format("} %s;  // class %s%s", class_name, decl.prim ? "box " : "", x.getName()));

			tosHdr.put_string_ln("");
			tosHdr.put_string_ln("");

			// TODO remove this block when constructors are added in dependent functions, etc in Deduce
			{
				// TODO what about named constructors and ctor$0 and "the debug stack"
				tos.put_string_ln(String.format("%s* ZC%d() {", class_name, class_code));
				tos.incr_tabs();
				tos.put_string_ln(String.format("%s* R = GC_malloc(sizeof(%s));", class_name, class_name));
				tos.put_string_ln(String.format("R->_tag = %d;", class_code));
				if (decl.prim) {
					// TODO consider NULL, and floats and longs, etc
					if (!decl.prim_decl.equals("bool"))
						tos.put_string_ln("R->vsv = 0;");
					else if (decl.prim_decl.equals("bool"))
						tos.put_string_ln("R->vsv = false;");
				} else {
					for (final GeneratedClass.VarTableEntry o : x.varTable) {
//					final String typeName = getTypeNameForVarTableEntry(o);
						// TODO this should be the result of getDefaultValue for each type
						tos.put_string_ln(String.format("R->vm%s = 0;", o.nameToken));
					}
				}
				tos.put_string_ln("return R;");
				tos.dec_tabs();
				tos.put_string_ln(String.format("} // class %s%s", decl.prim ? "box " : "", x.getName()));
				tos.put_string_ln("");
			}
			tos.flush();
		} finally {
			tos.close();
			tosHdr.close();
			final Buffer buf = tos.getBuffer();
//			LOG.info(buf.getText());
			gr.addClass(GenerateResult.TY.IMPL, x, buf, x.module().getLsp());
			final Buffer buf2 = tosHdr.getBuffer();
//			LOG.info(buf2.getText());
			gr.addClass(GenerateResult.TY.HEADER, x, buf2, x.module().getLsp());
		}
		x.generatedAlready = true;
	}

	String getRealTargetName(final @NotNull BaseGeneratedFunction gf, final @NotNull IntegerIA target, final Generate_Code_For_Method.AOG aog) {
		final VariableTableEntry varTableEntry = gf.getVarTableEntry(target.getIndex());
		return getRealTargetName(gf, varTableEntry);
	}

	@Deprecated
	String getTypeName(final @NotNull OS_Type ty) {
		return GetTypeName.forOSType(ty, LOG);
	}

	@NotNull List<String> getArgumentStrings(final BaseGeneratedFunction gf, final Instruction instruction) {
		final List<String> sl3       = new ArrayList<String>();
		final int          args_size = instruction.getArgsSize();
		for (int i = 1; i < args_size; i++) {
			final InstructionArgument ia = instruction.getArg(i);
			if (ia instanceof IntegerIA) {
//				VariableTableEntry vte = gf.getVarTableEntry(DeduceTypes2.to_int(ia));
				final String realTargetName = getRealTargetName(gf, (IntegerIA) ia, Generate_Code_For_Method.AOG.GET);
				sl3.add(Emit.emit("/*669*/") + realTargetName);
			} else if (ia instanceof IdentIA) {
				final CReference reference = new CReference();
				reference.getIdentIAPath((IdentIA) ia, Generate_Code_For_Method.AOG.GET, null);
				final String text = reference.build();
				sl3.add(Emit.emit("/*673*/") + text);
			} else if (ia instanceof final ConstTableIA c) {
				final ConstantTableEntry cte = gf.getConstTableEntry(c.getIndex());
				final String             s   = GetAssignmentValue.const_to_string(cte.initialValue);
				sl3.add(s);
				final int y = 2;
			} else if (ia instanceof ProcIA) {
				LOG.err("740 ProcIA");
				throw new NotImplementedException();
			} else {
				LOG.err(ia.getClass().getName());
				throw new IllegalStateException("Invalid InstructionArgument");
			}
		}
		return sl3;
	}

	@Deprecated
	String getTypeName(final @NotNull TypeName typeName) {
		return GetTypeName.forTypeName(typeName, errSink);
	}

	String getAssignmentValue(final VariableTableEntry aSelf, final Instruction aInstruction, final ClassInvocation aClsinv, final BaseGeneratedFunction gf) {
		final GetAssignmentValue gav = new GetAssignmentValue();
		return gav.forClassInvocation(aInstruction, aClsinv, gf, LOG);
	}

	@NotNull
	String getAssignmentValue(final VariableTableEntry value_of_this, final InstructionArgument value, final BaseGeneratedFunction gf) {
		final GetAssignmentValue gav = new GetAssignmentValue();
		if (value instanceof final FnCallArgs fca) {
			return gav.FnCallArgs(fca, gf, LOG);
		}

		if (value instanceof @NotNull final ConstTableIA constTableIA) {
			return gav.ConstTableIA(constTableIA, gf);
		}

		if (value instanceof final IntegerIA integerIA) {
			return gav.IntegerIA(integerIA, gf);
		}

		if (value instanceof final IdentIA identIA) {
			return gav.IdentIA(identIA, gf);
		}

		LOG.err(String.format("783 %s %s", value.getClass().getName(), value));
		return String.valueOf(value);
	}

	@NotNull List<String> getArgumentStrings(final @NotNull Supplier<IFixedList<InstructionArgument>> instructionSupplier) {
		final @NotNull List<String> sl3       = new ArrayList<String>();
		final int                   args_size = instructionSupplier.get().size();
		for (int i = 1; i < args_size; i++) {
			final InstructionArgument ia = instructionSupplier.get().get(i);
			if (ia instanceof IntegerIA) {
//				VariableTableEntry vte = gf.getVarTableEntry(DeduceTypes2.to_int(ia));
				final String realTargetName = getRealTargetName((IntegerIA) ia, Generate_Code_For_Method.AOG.GET);
				sl3.add(Emit.emit("/*669*/") + realTargetName);
			} else if (ia instanceof IdentIA) {
				final CReference reference = new CReference();
				reference.getIdentIAPath((IdentIA) ia, Generate_Code_For_Method.AOG.GET, null);
				final String text = reference.build();
				sl3.add(Emit.emit("/*673*/") + text);
			} else if (ia instanceof final ConstTableIA c) {
				final ConstantTableEntry cte = c.getEntry();
				final String             s   = GetAssignmentValue.const_to_string(cte.initialValue);
				sl3.add(s);
				final int y = 2;
			} else if (ia instanceof ProcIA) {
				LOG.err("740 ProcIA");
				throw new NotImplementedException();
			} else {
				LOG.err(ia.getClass().getName());
				throw new IllegalStateException("Invalid InstructionArgument");
			}
		}
		return sl3;
	}

	String getRealTargetName(final @NotNull IntegerIA target, final Generate_Code_For_Method.AOG aog) {
		final BaseGeneratedFunction gf            = target.gf;
		final VariableTableEntry    varTableEntry = gf.getVarTableEntry(target.getIndex());
		return getRealTargetName(gf, varTableEntry);
	}

	String getRealTargetName(final @NotNull BaseGeneratedFunction gf, final @NotNull IdentIA target, final Generate_Code_For_Method.AOG aog, final String value) {
		int                      state           = 0, code = -1;
		final IdentTableEntry    identTableEntry = gf.getIdentTableEntry(target.getIndex());
		final LinkedList<String> ls              = new LinkedList<String>();
		// TODO in Deduce set property lookupType to denote what type of lookup it is: MEMBER, LOCAL, or CLOSURE
		InstructionArgument backlink = identTableEntry.getBacklink();
		final String        text     = identTableEntry.getIdent().getText();
		if (backlink == null) {
			if (identTableEntry.getResolvedElement() instanceof final VariableStatement vs) {
				final OS_Element parent = vs.getParent().getParent();
				if (parent != gf.getFD()) {
					// we want identTableEntry.resolved which will be a GeneratedMember
					// which will have a container which will be either be a function,
					// statement (semantic block, loop, match, etc) or a GeneratedContainerNC
					final int           y  = 2;
					final GeneratedNode er = identTableEntry.externalRef;
					if (er instanceof final GeneratedContainerNC nc) {
						assert nc instanceof GeneratedNamespace;
						final GeneratedNamespace ns = (GeneratedNamespace) nc;
//						if (ns.isInstance()) {}
						state = 1;
						code  = nc.getCode();
					}
				}
			}
			switch (state) {
			case 0:
				ls.add(Emit.emit("/*912*/") + "vsc->vm" + text); // TODO blindly adding "vm" might not always work, also put in loop
				break;
			case 1:
				ls.add(Emit.emit("/*845*/") + String.format("zNZ%d_instance->vm%s", code, text));
				break;
			default:
				throw new IllegalStateException("Can't be here");
			}
		} else
			ls.add(Emit.emit("/*872*/") + "vm" + text); // TODO blindly adding "vm" might not always work, also put in loop
		while (backlink != null) {
			if (backlink instanceof final IntegerIA integerIA) {
				final String realTargetName = getRealTargetName(gf, integerIA, Generate_Code_For_Method.AOG.ASSIGN);
				ls.addFirst(Emit.emit("/*892*/") + realTargetName);
				backlink = null;
			} else if (backlink instanceof final IdentIA identIA) {
				final int             identIAIndex        = identIA.getIndex();
				final IdentTableEntry identTableEntry1    = gf.getIdentTableEntry(identIAIndex);
				final String          identTableEntryName = identTableEntry1.getIdent().getText();
				ls.addFirst(Emit.emit("/*885*/") + "vm" + identTableEntryName); // TODO blindly adding "vm" might not always be right
				backlink = identTableEntry1.getBacklink();
			} else
				throw new IllegalStateException("Invalid InstructionArgument for backlink");
		}
		final CReference reference = new CReference();
		reference.getIdentIAPath(target, aog, value);
		final String path = reference.build();
		LOG.info("932 " + path);
		final String s = Helpers.String_join("->", ls);
		LOG.info("933 " + s);
		if (identTableEntry.getResolvedElement() instanceof ConstructorDef || identTableEntry.getResolvedElement() instanceof PropertyStatement || value != null)
			return path;
		else
			return s;
	}

	static class WlGenerateFunctionC implements WorkJob {

		private final BaseGeneratedFunction gf;
		private final GenerateResult        gr;
		private final WorkList              wl;
		private final GenerateC             generateC;
		private       boolean               _isDone = false;

		public WlGenerateFunctionC(final BaseGeneratedFunction aGf, final GenerateResult aGr, final WorkList aWl, final GenerateC aGenerateC) {
			gf        = aGf;
			gr        = aGr;
			wl        = aWl;
			generateC = aGenerateC;
		}

		@Override
		public void run(final WorkManager aWorkManager) {
			if (gf instanceof GeneratedFunction)
				generateC.generate_function((GeneratedFunction) gf, gr, wl);
			else
				generateC.generate_constructor((GeneratedConstructor) gf, gr, wl);
			_isDone = true;
		}

		@Override
		public boolean isDone() {
			return _isDone;
		}
	}

	static class GetTypeName {
		static String forVTE(@NotNull final VariableTableEntry input) {
			final OS_Type attached = input.type.getAttached();
			if (attached == null)
				return Emit.emit("/*390*/") + "Z__Unresolved*"; // TODO remove this ASAP
			//
			// special case
			//
			if (input.type.genType.node != null)
				return Emit.emit("/*395*/") + getTypeNameForGenClass(input.type.genType.node) + "*";
			//
			if (input.getStatus() == BaseTableEntry.Status.UNCHECKED)
				return "Error_UNCHECKED_Type";
			switch (attached.getType()) {
			case USER_CLASS:
				return attached.getClassOf().name();
			case USER:
				final TypeName typeName = attached.getTypeName();
				final String name;
				if (typeName instanceof NormalTypeName)
					name = ((NormalTypeName) typeName).getName();
				else
					name = typeName.toString();
				return String.format(Emit.emit("/*543*/") + "Z<%s>*", name);
			default:
				throw new NotImplementedException();
			}
		}

		static String getTypeNameForGenClass(@NotNull final GeneratedNode aGenClass) {
			final String ty;
			if (aGenClass instanceof GeneratedClass)
				ty = forGenClass((GeneratedClass) aGenClass);
			else if (aGenClass instanceof GeneratedNamespace)
				ty = forGenNamespace((GeneratedNamespace) aGenClass);
			else
				ty = "Error_Unknown_GenClass";
			return ty;
		}

		static String forGenClass(@NotNull final GeneratedClass aGeneratedClass) {
			final String z;
			z = String.format("Z%d", aGeneratedClass.getCode());
			return z;
		}

		static String forGenNamespace(@NotNull final GeneratedNamespace aGeneratedNamespace) {
			final String z;
			z = String.format("Z%d", aGeneratedNamespace.getCode());
			return z;
		}

		static @NotNull String forTypeTableEntry(@NotNull final TypeTableEntry tte) {
			final GeneratedNode res = tte.resolved();
			if (res instanceof final GeneratedContainerNC nc) {
				final int code = nc.getCode();
				return "Z" + code;
			} else
				return "Z<-1>";
		}

		@Deprecated
		static String forOSType(final @NotNull OS_Type ty, final ElLog LOG) {
			if (ty == null) throw new IllegalArgumentException("ty is null");
			//
			final String z;
			switch (ty.getType()) {
			case USER_CLASS:
				final ClassStatement el = ty.getClassOf();
				final String name;
				if (ty instanceof NormalTypeName)
					name = ((NormalTypeName) ty).getName();
				else
					name = el.getName();
				z = Emit.emit("/*443*/") + String.format("Z%d/*%s*/", el._a.getCode(), name);//.getName();
				break;
			case FUNCTION:
				z = "<function>";
				break;
			case FUNC_EXPR: {
				z = "<function>";
				final OS_FuncExprType fe = (OS_FuncExprType) ty;
				final int             y  = 2;
			}
			break;
			case USER:
				final TypeName typeName = ty.getTypeName();
				LOG.err("Warning: USER TypeName in GenerateC " + typeName);
				final String s = typeName.toString();
				if (s.equals("Unit"))
					z = "void";
				else
					z = String.format("Z<Unknown_USER_Type /*%s*/>", s);
				break;
			case BUILT_IN:
				LOG.err("Warning: BUILT_IN TypeName in GenerateC");
				z = "Z" + ty.getBType().getCode();  // README should not even be here, but look at .name() for other code gen schemes
				break;
			case UNIT_TYPE:
				z = "void";
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + ty.getType());
			}
			return z;
		}

		@Deprecated
		static String forTypeName(final @NotNull TypeName typeName, final @NotNull ErrSink errSink) {
			if (typeName instanceof RegularTypeName) {
				final String name = ((RegularTypeName) typeName).getName(); // TODO convert to Z-name

				return String.format("Z<%s>/*kklkl*/", name);
//			    return getTypeName(new OS_Type(typeName));
			}
			errSink.reportError("Type is not fully deduced " + typeName);
			return String.format("Z<%s>/*kllkk*/", typeName); // TODO type is not fully deduced
		}
	}

//	@NotNull List<String> getArgumentStrings(final BaseGeneratedFunction gf, final Instruction instruction) {
//		return getArgumentStrings(gf, () -> new InstructionFixedList(instruction));
//	}

}

//
//
//
