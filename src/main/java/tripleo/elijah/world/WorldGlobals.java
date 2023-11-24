package tripleo.elijah.world;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public class WorldGlobals {

	private static final OS_Package _dp = new OS_Package(null, 0);

	public static OS_Package defaultPackage() {
		return _dp;
	}

}
