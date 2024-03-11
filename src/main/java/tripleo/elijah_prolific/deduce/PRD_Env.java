package tripleo.elijah_prolific.deduce;

import tripleo.elijah_prolific_durable.lang.Context;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceTypes2;

public record PRD_Env(DeduceTypes2 deduceTypes2, Context ctx, Object extra) {
	public enum Policy {
		ANY, /*ONCE, this is why you are having problems*/ CHECKED, UNCHECKED
	}
}
