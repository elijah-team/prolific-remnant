package tripleo.elijah_prolific_durable.comp.specs;

import tripleo.elijah.ci.*;
import tripleo.elijah_prolific_durable.ci.CompilerInstructions;

import java.util.*;

public interface EzCache {
	Optional<CompilerInstructions> get(String aAbsolutePath);

	void put(EzSpec aSpec, String aAbsolutePath, CompilerInstructions aR);
}
