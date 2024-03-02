package tripleo.elijah_prolific.eva;

import tripleo.elijah.stages.gen_fn.*;

public interface PR_EvaFunctionList {
	boolean contains(BaseGeneratedFunction aBaseGeneratedFunction);

	void add(BaseGeneratedFunction aBaseGeneratedFunction);

	boolean sizeAtLeast(int aDesiredCount);
}
