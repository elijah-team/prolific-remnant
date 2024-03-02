package tripleo.elijah_prolific.eva;

import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;

import java.util.*;

public enum PR_EvaFactory {
	;

	public static PR_EvaFunctionList newFunctionList() {
		final List<BaseGeneratedFunction> coll = new ArrayList<>();
		return new PR_EvaFunctionList() {
			@Override
			public boolean contains(final BaseGeneratedFunction aBaseGeneratedFunction) {
				return coll.contains(aBaseGeneratedFunction);
			}

			@Override
			public void add(final BaseGeneratedFunction aBaseGeneratedFunction) {
				coll.add(aBaseGeneratedFunction);
			}

			@Override
			public boolean sizeAtLeast(final int aDesiredCount) {
				return coll.size() >= aDesiredCount;
			}
		};
	}

	public static PR_DependentFunction newDependentFunction(final FunctionInvocation aDependentFunction, final Dependencies aDependencies) {
		return new PR_DependentFunction() {
			@Override
			public void attachNamespace(final GeneratedNamespace aGeneratedNamespace, final NamespaceInvocation aNamespaceInvocation) {
				aGeneratedNamespace.dependentFunctions().add(aDependentFunction);
			}

			@Override
			public void attachClass(final GeneratedClass aGeneratedClass, final ClassInvocation aClassInvocation) {
				aGeneratedClass.dependentFunctions().add(aDependentFunction);
			}
		};
	}
}
