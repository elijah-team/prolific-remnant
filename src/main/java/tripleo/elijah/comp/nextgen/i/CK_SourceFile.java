package tripleo.elijah.comp.nextgen.i;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.nextgen.inputtree.EIT_Input;
import tripleo.elijah.nextgen.outputtree.EOT_OutputFile;

public interface CK_SourceFile {
	CompilerInput compilerInput();

	EIT_Input input(); // s ??

	EOT_OutputFile output(); // s ??
}
