package tripleo.elijah.comp.i;

import java.util.List;

import tripleo.elijah.comp.CompilerInput;

@FunctionalInterface
public interface OptionsProcessor {
	String[] process(Compilation aC, List<CompilerInput> aInputs, ICompilationBus aCb) throws Exception;
}
