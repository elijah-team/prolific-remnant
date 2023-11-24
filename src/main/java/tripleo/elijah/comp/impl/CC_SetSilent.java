package tripleo.elijah.comp.impl;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public class CC_SetSilent implements CompilationChange {
	private final boolean flag;

	public CC_SetSilent(final boolean aB) {
		flag = aB;
	}

	@Override
	public void apply(final @NotNull Compilation c) {
		c.cfg().silent = flag;
	}
}
