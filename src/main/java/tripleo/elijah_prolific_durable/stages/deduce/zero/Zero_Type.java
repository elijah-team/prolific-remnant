package tripleo.elijah_prolific_durable.stages.deduce.zero;

import org.jetbrains.annotations.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.GenType;

class Zero_Type {

	private final GenType gt;

	@Contract(pure = true)
	public Zero_Type(final GenType aGt) {
		gt = aGt;
	}

	public GenType genType() {
		return gt;
	}
}
