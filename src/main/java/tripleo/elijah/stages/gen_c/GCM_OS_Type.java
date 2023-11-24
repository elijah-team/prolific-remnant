package tripleo.elijah.stages.gen_c;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public class GCM_OS_Type {
	private final OS_Type osType;

	public GCM_OS_Type(final OS_Type aOSType) {
		osType = aOSType;
	}

	public boolean isNull() {
		return osType == null;
	}

	public String getTypeName() {
		return getClass().getTypeName();
	}
}
