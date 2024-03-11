package tripleo.elijah_prolific_durable.testing.comp;

import tripleo.elijah_prolific_durable.lang.FunctionDef;
import tripleo.elijah_prolific_durable.stages.gen_fn.GeneratedFunction;

import java.util.Collection;

public interface IFunctionMapHook {
	boolean matches(FunctionDef aFunctionDef);

	void apply(Collection<GeneratedFunction> aGeneratedFunctions);
}
