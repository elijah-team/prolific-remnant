package tripleo.elijah_prolific_durable.stages.deduce.post_bytecode;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.diagnostic.*;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

import java.io.PrintStream;
import java.util.List;

public class ZeroPotentialDiagnostic implements Diagnostic {
	@Override
	public String code() {
		NotImplementedException.raise();
		return null;
	}

	@Override
	public Severity severity() {
		NotImplementedException.raise();
		return null;
	}

	@Override
	public @NotNull Locatable primary() {
		NotImplementedException.raise();
		return null;
	}

	@Override
	public @NotNull List<Locatable> secondary() {
		NotImplementedException.raise();
		return null;
	}

	@Override
	public void report(final PrintStream stream) {
		NotImplementedException.raise();
		final int y = 2;
	}
}