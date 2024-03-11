package tripleo.elijah_prolific_durable.world.i;

import tripleo.elijah.lang.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.world.impl.*;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.world.impl.*;

public interface LivingRepo {
	LivingClass addClass(ClassStatement cs);

	LivingFunction addFunction(BaseFunctionDef fd);

	LivingPackage addPackage(OS_Package pk);

	OS_Package getPackage(String aPackageName);

	DefaultLivingFunction addFunction(BaseGeneratedFunction aFunction, Add aMainFunction);

	DefaultLivingClass addClass(GeneratedClass aClass, Add aMainClass);

	void addNamespace(GeneratedNamespace aNamespace, Add aNone);

	enum Add {NONE, MAIN_FUNCTION, MAIN_CLASS}
}
