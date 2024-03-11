package tripleo.elijah_prolific_durable.stages.deduce.fluffy.i;

import tripleo.elijah_prolific_durable.diagnostic.Locatable;
import tripleo.elijah_prolific_durable.nextgen.composable.IComposable;

public interface FluffyVar {
	String name();

	Locatable nameLocatable();

	IComposable nameComposable();

	FluffyVarTarget target();
}
