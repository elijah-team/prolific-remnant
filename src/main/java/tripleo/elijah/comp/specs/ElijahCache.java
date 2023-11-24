package tripleo.elijah.comp.specs;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.*;

public interface ElijahCache {
	void put(ElijahSpec aSpec, String aAbsolutePath, OS_Module aModule);

	Optional<OS_Module> get(String aAbsolutePath);
}
