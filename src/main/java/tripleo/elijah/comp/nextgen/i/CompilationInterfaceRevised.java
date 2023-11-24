package tripleo.elijah.comp.nextgen.i;

import org.apache.commons.lang3.tuple.Pair;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.List;

public interface CompilationInterfaceRevised {
	Pair<CompOutput, CompInteractive> compile(List<CompilerInput> lci);
}
