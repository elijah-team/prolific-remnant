package tripleo.elijah_prolific_durable.world;

import tripleo.elijah_prolific_durable.lang.OS_Package;

public class WorldGlobals {

	private static final OS_Package _dp = new OS_Package(null, 0);

	public static OS_Package defaultPackage() {
		return _dp;
	}

}
