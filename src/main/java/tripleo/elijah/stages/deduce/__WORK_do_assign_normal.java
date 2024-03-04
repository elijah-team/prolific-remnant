package tripleo.elijah.stages.deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.fluffy2.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.util.NotImplementedException;
import tripleo.elijah_prolific.deduce.*;

public class __WORK_do_assign_normal {
	private final DeduceTypes2 deduceTypes2;

	public __WORK_do_assign_normal(final DeduceTypes2 aDeduceTypes2) {
		this.deduceTypes2 = aDeduceTypes2;
	}

	public void action(final @NotNull BaseGeneratedFunction generatedFunction, final Context aFd_ctx, final PRD_Instruction instruction, final Context aContext) {
		var env = new DT2_DAN_Env(generatedFunction, aFd_ctx, instruction, aContext, this.deduceTypes2);
		// TODO doesn't account for __assign__
		final InstructionArgument agn_lhs = instruction.getArg(0);
		if (agn_lhs instanceof final @NotNull IntegerIA arg) {
			final @NotNull VariableTableEntry vte = generatedFunction.getVarTableEntry(arg.getIndex());
			final InstructionArgument         i2  = instruction.getArg(1);
			if (i2 instanceof IntegerIA) {
				final @NotNull VariableTableEntry vte2 = generatedFunction.getVarTableEntry(DeduceTypes2.to_int(i2));
				vte.addPotentialType(instruction.getIndex(), vte2.type);
			} else if (i2 instanceof final @NotNull FnCallArgs fca) {
				((FluffyFnCallArgs) deduceTypes2.getFluffy(fca, env.generatedFunction())).do_assign_call(aContext, vte, instruction);
			} else if (i2 instanceof ConstTableIA ctia) {
				((FluffyConstTableIA) deduceTypes2.getFluffy(ctia, env.generatedFunction())).do_assign_constant(instruction, vte);
			} else if (i2 instanceof IdentIA) {
				@NotNull final IdentTableEntry idte = generatedFunction.getIdentTableEntry(DeduceTypes2.to_int(i2));
				if (idte.type == null) {
					final IdentIA identIA = new IdentIA(idte.getIndex(), generatedFunction);
					deduceTypes2.resolveIdentIA_(aContext, identIA, generatedFunction, new FoundElement(deduceTypes2.phase) {

						@Override
						public void foundElement(final OS_Element e) {
							deduceTypes2.found_element_for_ite(generatedFunction, idte, e, aContext);
						}

						@Override
						public void noFoundElement() {
							// TODO: log error
						}
					});
				}
				assert idte.type != null;
				assert idte.simpleHasResolvedElement();

				// README 24/03/03
				// the above line almost contradicts the below.
				// below controls
				idte.elementPromise(ell -> vte.addPotentialType(instruction.getIndex(), idte.type), null);
			} else if (i2 instanceof ProcIA) {
				throw new NotImplementedException();
			} else {
				throw new NotImplementedException();
			}
		} else if (agn_lhs instanceof final @NotNull IdentIA arg) {
			final @NotNull IdentTableEntry idte = arg.getEntry();
			final InstructionArgument      i2   = instruction.getArg(1);
			if (i2 instanceof IntegerIA) {
				final @NotNull VariableTableEntry vte2 = generatedFunction.getVarTableEntry(DeduceTypes2.to_int(i2));
				idte.addPotentialType(instruction.getIndex(), vte2.type);
			} else if (i2 instanceof final @NotNull FnCallArgs fca) {
				// work queue, imm/later
				// +/- https://www.baeldung.com/java-ee-7-batch-processing
				deduceTypes2.do_assign_call(generatedFunction, aFd_ctx, idte, fca, instruction.getIndex());
			} else if (i2 instanceof IdentIA) {
				if (idte.getResolvedElement() instanceof VariableStatement) {
					deduceTypes2.do_assign_normal_ident_deferred(generatedFunction, aFd_ctx, idte);
				}
				@NotNull final IdentTableEntry idte2 = generatedFunction.getIdentTableEntry(DeduceTypes2.to_int(i2));
				deduceTypes2.do_assign_normal_ident_deferred(generatedFunction, aFd_ctx, idte2);
				idte.addPotentialType(instruction.getIndex(), idte2.type);
			} else if (i2 instanceof ConstTableIA ctia) {
				((FluffyConstTableIA) deduceTypes2.getFluffy(ctia, env.generatedFunction())).do_assign_constant(instruction, idte);
			} else if (i2 instanceof ProcIA) {
				throw new NotImplementedException();
			} else
				throw new NotImplementedException();
		}
	}
}
