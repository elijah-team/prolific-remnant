package tripleo.elijah_prolific_durable.comp.specs;

import tripleo.elijah_prolific_durable.ci.CompilerInstructions;

import java.util.Optional;

public interface EzCache {
	Optional<CompilerInstructions> get(String aAbsolutePath);

	void put(EzSpec aSpec, String aAbsolutePath, CompilerInstructions aR);
}
