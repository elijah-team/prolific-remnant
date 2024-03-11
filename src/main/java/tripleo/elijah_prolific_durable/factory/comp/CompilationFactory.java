package tripleo.elijah_prolific_durable.factory.comp;

import org.jetbrains.annotations.*;
import tripleo.elijah_prolific_durable.comp.*;
import tripleo.elijah_prolific_durable.comp.internal.CompilationImpl;
import tripleo.elijah_prolific_durable.testing.comp.IFunctionMapHook;

import java.util.List;

public class CompilationFactory {

	public static CompilationImpl mkCompilation2(final List<IFunctionMapHook> aMapHooks) {
		final StdErrSink errSink = new StdErrSink();
		final IO         io      = new IO();

		final @NotNull CompilationImpl c = mkCompilation(errSink, io);

		c.testMapHooks(aMapHooks);

		return c;
	}

	@Contract("_, _ -> new")
	public static @NotNull CompilationImpl mkCompilation(final ErrSink eee, final IO io) {
		return new CompilationImpl(eee, io);
	}
}
