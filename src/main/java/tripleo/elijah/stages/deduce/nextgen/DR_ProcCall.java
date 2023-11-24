package tripleo.elijah.stages.deduce.nextgen;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.ProcTableEntry;

public class DR_ProcCall implements DR_Item {
	private final IExpression     z;
	private final ProcTableEntry  pte;
	private final BaseEvaFunction baseEvaFunction;

	public DR_ProcCall(final IExpression aZ, final ProcTableEntry aPte, final BaseEvaFunction aBaseEvaFunction) {
		z               = aZ;
		pte             = aPte;
		baseEvaFunction = aBaseEvaFunction;
	}

	public FunctionInvocation getFunctionInvocation() {
		return pte.getFunctionInvocation();
	}
}
