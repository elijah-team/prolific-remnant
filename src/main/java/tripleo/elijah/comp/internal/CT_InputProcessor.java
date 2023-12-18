package tripleo.elijah.comp.internal;

import tripleo.elijah.comp.*;
import tripleo.elijah.comp.i.*;

public interface CT_InputProcessor {
	void action(CompilerInput aCompilerInput);

	void process(CompilationClosure aC, CompilerInput aInput);
}
