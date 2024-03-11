package tripleo.elijah_prolific.eva;

import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.BaseGeneratedFunction;

public interface PR_EvaFunctionList {
	boolean contains(BaseGeneratedFunction aBaseGeneratedFunction);

	void add(BaseGeneratedFunction aBaseGeneratedFunction);

	boolean sizeAtLeast(int aDesiredCount);
}
