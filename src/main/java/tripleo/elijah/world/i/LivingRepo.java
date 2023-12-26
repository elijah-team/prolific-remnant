package tripleo.elijah.world.i;

import tripleo.elijah.lang.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.world.impl.*;

public interface LivingRepo {
	LivingClass addClass(ClassStatement cs);

	LivingFunction addFunction(BaseFunctionDef fd);

	LivingPackage addPackage(OS_Package pk);

	OS_Package getPackage(String aPackageName);

	DefaultLivingFunction addFunction(BaseEvaFunction aFunction, Add aMainFunction);

	DefaultLivingClass addClass(EvaClass aClass, Add aMainClass);

	void addNamespace(EvaNamespace aNamespace, Add aNone);

	enum Add {NONE, MAIN_FUNCTION, MAIN_CLASS}
}
