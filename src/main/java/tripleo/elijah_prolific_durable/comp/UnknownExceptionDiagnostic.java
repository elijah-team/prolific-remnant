package tripleo.elijah_prolific_durable.comp;

import org.jetbrains.annotations.*;
import tripleo.elijah.diagnostic.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.nextgen.query.*;
import tripleo.elijah_prolific_durable.diagnostic.*;
import tripleo.elijah_prolific_durable.lang.OS_Module;
import tripleo.elijah_prolific_durable.nextgen.query.Operation2;

import java.io.*;
import java.util.*;

class UnknownExceptionDiagnostic implements Diagnostic {
	private final Operation2<OS_Module> m;

	public UnknownExceptionDiagnostic(final Operation2<OS_Module> aM) {
		m = aM;
	}

	@Override
	public String code() {
		return "9002";
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
		stream.printf("%s Some error %s%n", code(), m.failure());
	}
}
