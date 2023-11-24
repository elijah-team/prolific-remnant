package tripleo.elijah.stages.gen_c;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.nextgen.outputstatement.EG_Statement;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_generic.GenerateResult;
import tripleo.util.buffer.Buffer;

public interface C2C_Result {
	Buffer getBuffer();

	EG_Statement getStatement();

	GenerateResult.TY ty();

	OS_Module getDefinedModule();

	WhyNotGarish_BaseFunction getWhyNotGarishFunction();
}
