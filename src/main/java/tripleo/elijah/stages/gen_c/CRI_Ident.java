package tripleo.elijah.stages.gen_c;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.util.*;

import java.util.*;
import java.util.function.*;

class CRI_Ident {
	private final IdentTableEntry       ite;
	private final BaseEvaFunction generatedFunction;

	public CRI_Ident(final IdentTableEntry aIdte, final BaseEvaFunction aGf) {
		ite               = aIdte;
		generatedFunction = aGf;
	}

	@Contract(value = "_, _ -> new", pure = true)
	public static @NotNull CRI_Ident of(final IdentTableEntry aIdte, final BaseEvaFunction aGf) {
		return new CRI_Ident(aIdte, aGf);
	}

	public String getIdentIAPath(int i,
	                             final int sSize,
	                             final Generate_Code_For_Method.AOG aog,
	                             final List<String> sl,
	                             final String aValue,
	                             final Consumer<CReference.Reference> addRef,
	                             final List<InstructionArgument> s,
	                             final IdentIA ia2,
	                             final CReference aCReference) {
		final boolean[]  skip             = {false};
		final OS_Element resolved_element = ite.getResolvedElement();
		final String[]   text             = {null};

		final EvaClass _cheat = aCReference._cheat;

		if (resolved_element != null) {
			EvaNode resolved = null;
			if (resolved_element instanceof ClassStatement) {
				resolved = _re_is_ClassStatement();
			} else if (resolved_element instanceof FunctionDef) {
				@Nullable final ProcTableEntry pte = ite.getCallablePTE();
				resolved = _re_is_FunctionDef(pte, _cheat);
			} else if (resolved_element instanceof PropertyStatement) {
				resolved = _re_is_PropertyStatement(addRef, aog, sSize, i, aValue, (x) -> skip[0] = true, (x) -> text[0] = x);
			}
			if (!skip[0]) {
				short state = 1;
				if (ite.externalRef != null) {
					state = 2;
				}
				switch (state) {
				case 1:
					if (resolved == null) {
						SimplePrintLoggerToRemoveSoon.println_err("***88*** resolved is null for " + ite);
					}
					if (sSize >= i + 1) {
						_getIdentIAPath_IdentIAHelper(null, sl, i, sSize, resolved_element, generatedFunction, resolved, aValue, aCReference);
						text[0] = null;
					} else {
						final boolean b = _getIdentIAPath_IdentIAHelper(s.get(i + 1), sl, i, sSize, resolved_element, generatedFunction, resolved, aValue, aCReference);
						if (b) i++;
					}
					break;
				case 2:
					if ((resolved_element instanceof VariableStatement)) {
						final String text2 = ((VariableStatement) resolved_element).getName();

						final EvaNode externalRef = ite.externalRef;
						if (externalRef instanceof EvaNamespace) {
							final String text3 = String.format("zN%d_instance", ((EvaNamespace) externalRef).getCode());
							addRef.accept(new CReference.Reference(text3, CReference.Ref.LITERAL, null));
						} else if (externalRef instanceof EvaClass) {
							assert false;
							final String text3 = String.format("zN%d_instance", ((EvaClass) externalRef).getCode());
							addRef.accept(new CReference.Reference(text3, CReference.Ref.LITERAL, null));
						} else
							throw new IllegalStateException();
						addRef.accept(new CReference.Reference(text2, CReference.Ref.MEMBER, aValue));
					} else
						throw new NotImplementedException();
					break;
				}
			}
		} else {
			switch (ite.getStatus()) {
			case KNOWN:
				assert false;
				break;
			case UNCHECKED:
				final String path2 = generatedFunction.getIdentIAPathNormal(ia2);
				final String text3 = String.format("<<UNCHECKED ia2: %s>>", path2/*idte.getIdent().getText()*/);
				text[0] = text3;
//						assert false;
				break;
			case UNKNOWN:
				final String path = generatedFunction.getIdentIAPathNormal(ia2);
				final String text1 = ite.getIdent().getText();
//						assert false;
				// TODO make tests pass but I dont like this (should emit a dummy function or placeholder)
				if (sl.size() == 0) {
					text[0] = Emit.emit("/*149*/") + text1; // TODO check if it belongs somewhere else (what does this mean?)
				} else {
					text[0] = Emit.emit("/*152*/") + "vm" + text1;
				}
				SimplePrintLoggerToRemoveSoon.println_err("119 " + ite.getIdent() + " " + ite.getStatus());
				final String text2 = (Emit.emit("/*114*/") + String.format("%s is UNKNOWN", text1));
				addRef.accept(new CReference.Reference(text2, CReference.Ref.MEMBER));
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + ite.getStatus());
			}
		}

		return text[0];
	}

	private EvaNode _re_is_ClassStatement() {
		EvaNode resolved = null;
		if (ite.type != null)
			resolved = ite.type.resolved();
		if (resolved == null)
			resolved = ite.resolvedType();
		return resolved;
	}

	private EvaNode _re_is_FunctionDef(final @Nullable ProcTableEntry pte, final EvaClass a_cheat) {
		EvaNode resolved = null;
		if (pte != null) {
			final FunctionInvocation fi = pte.getFunctionInvocation();
			if (fi != null) {
				final BaseEvaFunction gen = fi.getEva();
				if (gen != null)
					resolved = gen;
			}
		}
		if (resolved == null) {
			final EvaNode resolved1 = ite.resolvedType();
			if (resolved1 instanceof EvaFunction)
				resolved = resolved1;
			else if (resolved1 instanceof EvaClass) {
				resolved = resolved1;

				// FIXME Bar#quux is not being resolves as a BGF in Hier

//								FunctionInvocation fi = pte.getFunctionInvocation();
//								fi.setClassInvocation();
			}
		}

		if (resolved == null) {
			resolved = a_cheat;
		}

		return resolved;
	}

	private EvaNode _re_is_PropertyStatement(final Consumer<CReference.Reference> addRef,
	                                               final Generate_Code_For_Method.AOG aog,
	                                               final int sSize,
	                                               final int i,
	                                               final String aValue,
	                                               final Consumer<Void> skip,
	                                               final Consumer<String> text) {
		NotImplementedException.raise();
		final EvaNode resolved1 = ite.type.resolved();
		final int           code;
		if (resolved1 != null)
			code = ((EvaContainerNC) resolved1).getCode();
		else
			code = -1;
		short state = 0;
		if (i < sSize - 1) {
			state = 1;
		} else {
			switch (aog) {
			case GET:
				state = 1;
				break;
			case ASSIGN:
				state = 2;
				break;
			}
		}
		switch (state) {
		case 1:
			addRef.accept(new CReference.Reference(String.format("ZP%d_get%s(", code, ite.getIdent().getText()), CReference.Ref.PROPERTY_GET));
			skip.accept(null);
			text.accept(null);
			break;
		case 2:
			addRef.accept(new CReference.Reference(String.format("ZP%d_set%s(", code, ite.getIdent().getText()), CReference.Ref.PROPERTY_SET, aValue));
			skip.accept(null);
			text.accept(null);
			break;
		default:
			throw new IllegalStateException("Unexpected value: " + state);
		}
		return resolved1;
	}

	boolean _getIdentIAPath_IdentIAHelper(final InstructionArgument ia_next,
	                                      final List<String> sl,
	                                      final int i,
	                                      final int sSize,
	                                      final OS_Element resolved_element,
	                                      final BaseEvaFunction generatedFunction,
	                                      final EvaNode aResolved,
	                                      final String aValue, final CReference aCReference) {
		return new CReference_getIdentIAPath_IdentIAHelper(ia_next, sl, i, sSize, resolved_element, generatedFunction, aResolved, aValue).action(this, aCReference);
	}
}
