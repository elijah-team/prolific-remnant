package tripleo.elijah_prolific_durable.comp.specs;

import tripleo.elijah_prolific_durable.lang.OS_Module;

import java.util.Optional;

public interface ElijahCache {
	void put(ElijahSpec aSpec, String aAbsolutePath, OS_Module aModule);

	Optional<OS_Module> get(String aAbsolutePath);
}
