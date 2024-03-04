package tripleo.elijah.stages.deduce;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.fluffy2.FluffyConstTableIA;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah_prolific.deduce.*;

class __WORK_deduce_generated_function_base {
//	private final DeduceTypes2          deduceTypes2;
	private       BaseGeneratedFunction generatedFunction;
	private       BaseFunctionDef       fd;
	private       DeduceTypes2          deduceTypes2;

//	public __WORK_deduce_generated_function_base(final DeduceTypes2 aDeduceTypes2) {
//		deduceTypes2 = aDeduceTypes2;
//	}

	public void instructionLoop() {
		assert deduceTypes2 != null;

		for (final @NotNull Instruction instruction0 : generatedFunction.instructions()) {
			//noinspection ObjectAllocationInLoop
			final var instruction = deduceTypes2.factory().newPRD_Instruction1(instruction0);

			final Context context = generatedFunction.getContextFromPC(instruction.getIndex());

			// LOG.info("8006 " + instruction);

			switch (instruction.getName()) {
			case E:
				deduceTypes2.onEnterFunction(generatedFunction, context);
				break;
			case X:
				deduceTypes2.onExitFunction(generatedFunction, fd_ctx, context);
				break;
			case ES:
				break;
			case XS:
				break;
			case AGN:
				deduceTypes2.do_assign_normal(generatedFunction, fd_ctx, instruction, context);
				break;
			case AGNK: {
				final @NotNull IntegerIA          arg  = (IntegerIA) instruction.getArg(0);
				final @NotNull VariableTableEntry vte  = generatedFunction.getVarTableEntry(arg.getIndex());
				final InstructionArgument         i2   = instruction.getArg(1);
				final @NotNull ConstTableIA       ctia = (ConstTableIA) i2;
				((FluffyConstTableIA) deduceTypes2.getFluffy(ctia, generatedFunction)).do_assign_constant(instruction, vte);
			}
			break;
			case AGNT:
				break;
			case AGNF:
				deduceTypes2.LOG.info("292 Encountered AGNF");
				break;
			case JE:
				deduceTypes2.LOG.info("296 Encountered JE");
				break;
			case JNE:
				break;
			case JL:
				break;
			case JMP:
				break;
			case CALL:
				do_call(instruction, context);
				break;
			case CALLS:
				do_calls(instruction);
				break;
			case RET:
				break;
			case YIELD:
				break;
			case TRY:
				break;
			case PC:
				break;
			case CAST_TO:
				// README potentialType info is already added by MatchConditional
				break;
			case DECL:
				// README for GenerateC, etc: marks the spot where a declaration should go. Wouldn't be necessary if we had proper Range's
				break;
			case IS_A:
				deduceTypes2.implement_is_a(generatedFunction, instruction);
				break;
			case NOP:
				break;
			case CONSTRUCT:
				deduceTypes2.implement_construct(generatedFunction, instruction/*, context*/);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + instruction.getName());
			}
		}
	}

	// hmm
	private void do_calls(final PRD_Instruction instruction) {
		final int                     i1  = DeduceTypes2.to_int(instruction.getArg(0));
		final InstructionArgument     i2  = (instruction.getArg(1));
		final @NotNull ProcTableEntry fn1 = generatedFunction.getProcTableEntry(i1);
		{
			deduceTypes2.implement_calls(generatedFunction, fd_ctx, i2, fn1, instruction.getIndex());
		}
/*
			if (i2 instanceof IntegerIA) {
				int i2i = to_int(i2);
				VariableTableEntry vte = generatedFunction.getVarTableEntry(i2i);
				int y =2;
			} else
				throw new NotImplementedException();
*/
	}

	// hmm
	private void do_call(final PRD_Instruction instruction, final Context context) {
		final int                     pte_num = ((ProcIA) instruction.getArg(0)).getIndex();
		final @NotNull ProcTableEntry pte     = generatedFunction.getProcTableEntry(pte_num);
//				final InstructionArgument i2 = (instruction.getArg(1));
		{
			final @NotNull IdentIA identIA = (IdentIA) pte.expression_num;
			final String           x       = generatedFunction.getIdentIAPathNormal(identIA);
			deduceTypes2.LOG.info("298 Calling " + x);
			deduceTypes2.resolveIdentIA_(context, identIA, generatedFunction, new FoundElement(deduceTypes2.phase) {

				@SuppressWarnings("unused")
				final String xx = x;

				@Override
				public void foundElement(final OS_Element e) {
					pte.setStatus(BaseTableEntry.Status.KNOWN, new ConstructableElementHolder(e, identIA));
					if (fd instanceof DefFunctionDef) {
						final IInvocation invocation = deduceTypes2.getInvocation((GeneratedFunction) generatedFunction);
						deduceTypes2.forFunction(deduceTypes2.newFunctionInvocation((FunctionDef) e, pte, invocation, deduceTypes2.phase), new ForFunction() {
							@Override
							public void typeDecided(@NotNull final GenType aType) {
								@Nullable final InstructionArgument x = generatedFunction.vte_lookup("Result");
								assert x != null;
								((IntegerIA) x).getEntry().type.setAttached(deduceTypes2.gt(aType));
							}
						});
					}
				}

				@Override
				public void noFoundElement() {
					deduceTypes2.errSink.reportError("370 Can't find callsite " + x);
					// TODO don't know if this is right
					@NotNull final IdentTableEntry entry = identIA.getEntry();
					if (entry.getStatus() != BaseTableEntry.Status.UNKNOWN)
						entry.setStatus(BaseTableEntry.Status.UNKNOWN, null);
				}
			});
		}
	}

	public void init(final BaseGeneratedFunction aGeneratedFunction, final BaseFunctionDef aFd, final DeduceTypes2 aDeduceTypes2) {
		generatedFunction = aGeneratedFunction;
		fd                = aFd;
		deduceTypes2      = aDeduceTypes2;
		fd_ctx            = fd.getContext();
	}

	private Context fd_ctx;

	public void enterLog(final ElLog aLOG) {
		final ProcTableEntry  pte        = generatedFunction.fi.pte;
		final @NotNull String pte_string = deduceTypes2.getPTEString(pte);
		aLOG.err("** deduce_generated_function " + fd.name() + " " + pte_string);
		//+" "+((OS_Container)((FunctionDef)fd).getParent()).name());
	}

	public void postVteList() {
		for (final @NotNull VariableTableEntry vte : generatedFunction.vte_list) {
			if (vte.type.getAttached() == null) {
				final int potential_size = vte.potentialTypes().size();
				if (potential_size == 1)
					vte.type.setAttached(deduceTypes2.getPotentialTypesVte(vte).get(0).getAttached());
				else if (potential_size > 1) {
					// TODO Check type compatibility
					deduceTypes2.LOG.err("703 " + vte.getName() + " " + vte.potentialTypes());
					deduceTypes2.errSink.reportDiagnostic(new CantDecideType(vte, vte.potentialTypes()));
				} else {
					// potential_size == 0
					// Result is handled by phase.typeDecideds, self is always valid
					if (/*vte.getName() != null &&*/ !(vte.vtt == VariableTableType.RESULT || vte.vtt == VariableTableType.SELF))
						deduceTypes2.errSink.reportDiagnostic(new CantDecideType(vte, vte.potentialTypes()));
				}
			} else if (vte.vtt == VariableTableType.RESULT) {
				final OS_Type attached = vte.type.getAttached();
				if (attached.getType() == OS_Type.Type.USER) {
					try {
						vte.type.setAttached(deduceTypes2.resolve_type(attached, fd_ctx));
					} catch (final ResolveError aResolveError) {
						aResolveError.printStackTrace();
						assert false;
					}
				}
			}
		}
	}

	public void calculateDeferredCalls(final @NotNull BaseGeneratedFunction generatedFunction) {
		//
		// NOW CALCULATE DEFERRED CALLS
		//
		for (final Integer deferred_call : generatedFunction.deferred_calls) {
			final Instruction instruction = generatedFunction.getInstruction(deferred_call);

			final int                     i1  = DeduceTypes2.to_int(instruction.getArg(0));
			final InstructionArgument     i2  = (instruction.getArg(1));
			final @NotNull ProcTableEntry fn1 = generatedFunction.getProcTableEntry(i1);
			{
//					generatedFunction.deferred_calls.remove(deferred_call);
				this.deduceTypes2.implement_calls_(generatedFunction, fd_ctx, i2, fn1, instruction.getIndex());
			}
		}
	}
}
