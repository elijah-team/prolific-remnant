package tripleo.elijah_prolific_durable.comp.i;

import tripleo.elijah_prolific_durable.comp.*;

public interface CompilationClosure {
	ErrSink errSink();

	Compilation getCompilation();

	IO io();
}
