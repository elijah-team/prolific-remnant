package tripleo.elijah.comp.i;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.List;

public interface CompilerController {
	void _setInputs(Compilation aCompilation, List<CompilerInput> aInputs);

	void printUsage();

	void processOptions();

	void runner();
}
