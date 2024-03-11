package tripleo.elijah_prolific_durable.stages.deduce.post_bytecode;

import org.jetbrains.annotations.NotNull;

public interface Stateful {
	void mvState(State aO, @NotNull State aState);

	void setState(final State aState);
}
