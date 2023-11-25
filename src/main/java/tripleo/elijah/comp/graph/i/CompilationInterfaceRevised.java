package tripleo.elijah.comp.graph.i;

import org.apache.commons.lang3.tuple.*;
import tripleo.elijah.comp.*;

import java.util.*;

public interface CompilationInterfaceRevised {
	Pair<CompOutput, CompInteractive> compile(List<CompilerInput> lci);
}
