package tripleo.elijah_prolific.deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.lang.Context;
import tripleo.elijah_prolific_durable.lang.OS_Element;
import tripleo.elijah_prolific_durable.lang.IdentExpression;
import tripleo.elijah_prolific_durable.lang.VariableStatement;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceLookupUtils;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceTypes2;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.util.Eventual;
import tripleo.elijah_prolific.gen_fn.PRN_vteTrigger;

public class PRD_vteTrigger_do_assign_call implements PRN_vteTrigger {
	private final DeduceTypes2 deduceTypes2;

	public PRD_vteTrigger_do_assign_call(final DeduceTypes2 aDeduceTypes2) {
		deduceTypes2 = aDeduceTypes2;
	}

	public void extracted111(final @NotNull Context ctx,
	                         final @NotNull VariableTableEntry vte,
	                         final @NotNull ProcTableEntry pte) {
		if (vte.getStatus() == BaseTableEntry.Status.UNCHECKED) {
			pte.typePromise().then(vte::resolveType);

			final OS_Element resolvedElement = vte.getResolvedElement();

			if (resolvedElement != null) {
				final @NotNull Eventual<OS_Element> elp;

				elp = DeduceLookupUtils.lookupP(extractIdentExpression(resolvedElement), ctx, deduceTypes2);

				elp.then(el-> vte.setStatus(BaseTableEntry.Status.KNOWN, new GenericElementHolder(el)));
				elp.onFail(deduceTypes2._errSink()::reportDiagnostic);
			}
		} else {
			assert false;
		}
	}

	@SuppressWarnings("PatternVariableCanBeUsed")
	private IdentExpression extractIdentExpression(final OS_Element aResolvedElement) {
		if (aResolvedElement instanceof IdentExpression) {
			final IdentExpression identExpression = (IdentExpression) aResolvedElement;
			return identExpression;
		} else if (aResolvedElement instanceof VariableStatement) {
			final VariableStatement variableStatement = (VariableStatement) aResolvedElement;
			return variableStatement.getNameToken();
		} else {
			throw new IllegalStateException("9996-043 Expecting IdentExpression or VariableStatement");
		}
	}

	@Override
	public PRD_Env.Policy getPolicy() {
		return PRD_Env.Policy.UNCHECKED;
	}
}
