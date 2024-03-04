package tripleo.elijah_prolific.deduce;

import tripleo.elijah.lang.Context;
import tripleo.elijah.stages.deduce.DeduceTypes2;

public record PRD_Env(DeduceTypes2 deduceTypes2, Context ctx, Object extra) {
	public enum Policy {
		ANY, /*ONCE, this is why you are having problems*/ CHECKED, UNCHECKED
	}
}
