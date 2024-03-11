package tripleo.elijah_prolific_durable.stages.gen_generic;

import org.jetbrains.annotations.*;

import java.util.function.*;

public class DoubleLatch<T> {
	private final @NotNull Consumer<T> action;
	private                T           tt;
	private                boolean     simple;

	//private IincInsnNode action;

	@Contract(pure = true)
	public DoubleLatch(final Consumer<T> aAction) {
		action = aAction;
	}

	public void notify(final T att) {
		tt = att;
		if (simple && tt != null) {
			action.accept(tt);
		}
	}

	public void notify(final boolean ass) {
		simple = ass;
		if (simple && tt != null) {
			action.accept(tt);
		}
	}
}
