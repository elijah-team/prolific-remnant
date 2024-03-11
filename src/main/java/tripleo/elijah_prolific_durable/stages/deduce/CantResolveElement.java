package tripleo.elijah_prolific_durable.stages.deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.diagnostic.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;

import java.io.PrintStream;
import java.util.List;

public class CantResolveElement implements Diagnostic {
	private final String                message;
	private final IdentTableEntry       identTableEntry;
	private final BaseGeneratedFunction generatedFunction;

	public CantResolveElement(final String aMessage, final IdentTableEntry aIdentTableEntry, final BaseGeneratedFunction aBaseGeneratedFunction) {
		message           = aMessage;
		identTableEntry   = aIdentTableEntry;
		generatedFunction = aBaseGeneratedFunction;
	}

	@Override
	public String code() {
		return null;
	}

	@Override
	public Severity severity() {
		return null;
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
		stream.println(message);
	}
}
