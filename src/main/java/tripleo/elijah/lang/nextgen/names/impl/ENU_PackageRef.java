package tripleo.elijah.lang.nextgen.names.impl;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public class ENU_PackageRef implements EN_Understanding {
	private final OS_Package pkg;

	public ENU_PackageRef(final OS_Package aPkg) {
		pkg = aPkg;
	}

	public OS_Package getPackage() {
		return pkg;
	}
}
