package tripleo.elijah_prolific.eva;

import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.stages.deduce.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;

public interface PR_DependentFunction {
	void attachNamespace(GeneratedNamespace aGeneratedNamespace, NamespaceInvocation aNamespaceInvocation);

	void attachClass(GeneratedClass aGeneratedClass, ClassInvocation aClassInvocation);
}
