package tripleo.elijah.lang.nextgen.names.impl;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.ProcTableEntry;

public class ENU_TypeTransitiveOver implements EN_Understanding {
	private final @NotNull ProcTableEntry pte;

	public ENU_TypeTransitiveOver(final @NotNull ProcTableEntry aPte) {

		pte = aPte;
	}
}
