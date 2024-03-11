package tripleo.elijah_prolific_durable.comp.diagnostic;

import org.jetbrains.annotations.*;
import tripleo.elijah.diagnostic.*;
import tripleo.elijah_prolific_durable.diagnostic.*;

import java.io.*;
import java.util.*;

public class TooManyEz_ActuallyNone implements Diagnostic {
	final String message = "No .ez files found.";

	@Override
	public String code() {
		return "9999";
	}

	@Override
	public Severity severity() {
		return Severity.ERROR;
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
		stream.printf("%s %s%n", code(), message);
	}
}
