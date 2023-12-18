package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.CompilerInstructionsImpl;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public class CR_ProcessInitialAction implements CR_Action {
	private final @NotNull CompilerInstructionsImpl ci;
	private                CompilationRunner        compilationRunner;

	@Contract(pure = true)
	public CR_ProcessInitialAction(final @NotNull CompilerBeginning beginning) {
		this((CompilerInstructionsImpl) beginning.compilerInstructions());
	}

	@Contract(pure = true)
	public CR_ProcessInitialAction(final @NotNull CompilerInstructionsImpl aCi) {
		ci     = aCi;
	}

	@Override
	public void attach(final @NotNull CompilationRunner cr) {
		compilationRunner = cr;
	}

	@Override
	public @NotNull Operation<Ok> execute(final @NotNull CR_State st, final CB_Output aO) {
		compilationRunner = st.runner();

		try {
			compilationRunner._accessCompilation().use(ci);
			return Operation.success(Ok.instance());
		} catch (final Exception aE) {
			return Operation.failure(aE);
		}
	}

	@Override
	public @NotNull String name() {
		return "process initial";
	}
}
