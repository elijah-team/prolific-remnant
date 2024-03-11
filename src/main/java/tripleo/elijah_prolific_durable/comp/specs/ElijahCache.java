package tripleo.elijah_prolific_durable.comp.specs;

import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.lang.OS_Module;

import java.util.*;

public interface ElijahCache {
	void put(ElijahSpec aSpec, String aAbsolutePath, OS_Module aModule);

	Optional<OS_Module> get(String aAbsolutePath);
}
