package tripleo.elijah_prolific_durable.comp;

import java.util.List;

public interface CompilerController {
	void printUsage();

	void processOptions();

	void runner();

	void _set(Compilation aCompilation, List<String> aArgs);
}
