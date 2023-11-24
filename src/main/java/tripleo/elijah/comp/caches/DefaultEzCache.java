package tripleo.elijah.comp.caches;

import tripleo.elijah.ci.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.*;

public class DefaultEzCache implements EzCache {
	final         Map<String, CompilerInstructions> fn2ci   = new HashMap<String, CompilerInstructions>();

	@Override
	public Optional<CompilerInstructions> get(final String absolutePath) {
		if (fn2ci.containsKey(absolutePath)) {
			return Optional.of(fn2ci.get(absolutePath));
		}

		return Optional.empty();
	}

	@Override
	public void put(final EzSpec aSpec, final String aAbsolutePath, final CompilerInstructions aCompilerInstructions) {
		fn2ci.put(aAbsolutePath, aCompilerInstructions);
	}
}
