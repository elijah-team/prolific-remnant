package tripleo.elijah.stages.gen_generic;

import com.google.common.base.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.stages.gen_c.GenerateC;
import tripleo.elijah.util.NotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum OutputFileFactory {
	;

	private static Map<OS_Module, GenerateFiles> mgfMap = new HashMap<>();

	@Contract("_, _, _ -> new")
	public static @NotNull GenerateFiles
	create(final String lang,
	       final OutputFileFactoryParams params,
	       final GenerateResultEnv aFileGen) {
		@NotNull GenerateFiles result;

		Preconditions.checkNotNull(lang);
		Preconditions.checkNotNull(params);

		if (Objects.equals(lang, "c")) {
			final OS_Module mod = params.getMod();

			if (mgfMap.containsKey(mod)) {
				result = mgfMap.get(mod);
			} else {
				final GenerateFiles generateC = new GenerateC(params, aFileGen);
				mgfMap.put(mod, generateC);
				result = generateC;
			}
		} else {
			throw new NotImplementedException();
		}

		Preconditions.checkNotNull(result);
		return result;
	}
}
