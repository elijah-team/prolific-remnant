package tripleo.elijah.lang.nextgen.names.impl;

import tripleo.elijah.lang.FunctionDef;
import tripleo.elijah.lang.nextgen.names.i.EN_Understanding;

public class ENU_FunctionDefinition implements EN_Understanding {
	private final FunctionDef carrier;

	public ENU_FunctionDefinition(final FunctionDef aFunctionDef) {
		carrier = aFunctionDef;
	}

	public FunctionDef getCarrier() {
		return carrier;
	}
}
