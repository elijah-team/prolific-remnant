package tripleo.elijah.stages.deduce.fluffy2;

import tripleo.elijah.lang.Context;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.gen_fn.BaseGeneratedFunction;
import tripleo.elijah_prolific.deduce.*;

public record DT2_DAN_Env(
		BaseGeneratedFunction generatedFunction,
		Context fd_ctx,
		PRD_Instruction instruction,
		Context context,
		DeduceTypes2 deduceTypes2
) {
}
