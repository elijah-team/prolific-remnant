package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.ArrayList;
import java.util.List;

class NotableAction implements CB_Action {
	private final @NotNull GN_Notable            notable;
	@NotNull
	final                  List<CB_OutputString> o;

	public NotableAction(final @NotNull GN_Notable aNotable) {
		notable = aNotable;
		o       = new ArrayList<>();
	}

	public void _actual_run() {
		notable.run();
	}

	@Override
	public void execute() {
		if (false) notable.run();
	}

	@Override
	public @NotNull String name() {
		return "Notable wrapper";
	}

	@Override
	public List<CB_OutputString> outputStrings() {
		return o;
	}
}
