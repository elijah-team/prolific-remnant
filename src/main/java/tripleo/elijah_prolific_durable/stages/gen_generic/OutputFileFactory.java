package tripleo.elijah_prolific_durable.stages.gen_generic;

import org.jetbrains.annotations.*;
import tripleo.elijah_prolific_durable.stages.gen_c.GenerateC;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

import java.util.Objects;

public final class OutputFileFactory {
	private OutputFileFactory() {
	}

	@Contract("_, _ -> new")
	public static @NotNull GenerateFiles create(final @NotNull String lang,
	                                            final @NotNull OutputFileFactoryParams params) {
		if (Objects.equals(lang, "c")) {
			return new GenerateC(params);
		} else
			throw new NotImplementedException();
	}
}
