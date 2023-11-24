package tripleo.elijah.lang.nextgen.names.impl;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public class ENU_FunctionDefinition implements EN_Understanding {
	private final FunctionDefImpl carrier;

	public ENU_FunctionDefinition(final FunctionDefImpl aFunctionDef) {
		carrier = aFunctionDef;
	}

	public FunctionDefImpl getCarrier() {
		return carrier;
	}
}
