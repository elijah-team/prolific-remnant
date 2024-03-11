package tripleo.elijah_prolific_durable.comp.diagnostic;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.diagnostic.*;

import java.io.*;
import java.util.List;

public class FileNotFoundDiagnostic implements Diagnostic {
	private final File f;

	public FileNotFoundDiagnostic(final File aLocal_prelude) {
		f = aLocal_prelude;
	}

	@Override
	public String code() {
		return "9004";
	}

	@Override
	public Severity severity() {
		return Severity.INFO;
	}

	@Override
	public @NotNull Locatable primary() {
		return null;
	}

	@Override
	public @NotNull List<Locatable> secondary() {
		return null;
	}

	@Override
	public void report(final PrintStream stream) {
		stream.println(code() + " File not found " + f.toString());
	}
}
