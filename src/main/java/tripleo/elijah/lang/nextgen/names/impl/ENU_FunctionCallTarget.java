package tripleo.elijah.lang.nextgen.names.impl;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.ProcTableEntry;

public class ENU_FunctionCallTarget implements EN_Understanding {
	private final ProcTableEntry pte;

	public ENU_FunctionCallTarget(final ProcTableEntry aPte) {

		pte = aPte;
	}
}
