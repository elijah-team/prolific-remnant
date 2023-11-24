package tripleo.elijah.testing.comp;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.*;

import java.util.*;

public interface IFunctionMapHook {
	boolean matches(FunctionDef aFunctionDef);

	void apply(Collection<GeneratedFunction> aGeneratedFunctions);
}
