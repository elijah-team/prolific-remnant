package tripleo.elijah.stages.gen_c;

import org.jetbrains.annotations.*;
import tripleo.elijah.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;

public interface DeducedBaseEvaFunction extends IEvaFunctionBase {
	void onGenClass(@NotNull OnGenClass aOnGenClass);

	BaseEvaFunction_Reactive reactive();

	IEvaFunctionBase getCarrier();

	OS_Module getModule__();

	WhyNotGarish_Function getWhyNotGarishFunction(GenerateC aGc);

	Eventual<GenType> typeDeferred();

	Eventual<GenType> typePromise();
}
