package tripleo.elijah.stages.deduce;

import org.jetbrains.annotations.*;
import tripleo.elijah.diagnostic.*;
import tripleo.elijah.stages.gen_fn.*;

import java.io.*;
import java.util.*;

public class CantResolveElement implements Diagnostic {
	private final String                message;
	private final IdentTableEntry       identTableEntry;
	private final BaseEvaFunction generatedFunction;

	public CantResolveElement(final String aMessage, final IdentTableEntry aIdentTableEntry, final BaseEvaFunction aBaseEvaFunction) {
		message           = aMessage;
		identTableEntry   = aIdentTableEntry;
		generatedFunction = aBaseEvaFunction;
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
