package tripleo.elijah.lang.nextgen.names.impl;

import tripleo.elijah.lang.nextgen.names.i.EN_Usage;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.BaseTableEntry;
import tripleo.elijah.stages.instructions.InstructionArgument;

public class EN_DeduceUsage implements EN_Usage {
	private final InstructionArgument backlink;
	private       BaseEvaFunction     EvaFunction;
	private       BaseTableEntry      bte;

	public EN_DeduceUsage(final InstructionArgument aBacklink, BaseEvaFunction EvaFunction, BaseTableEntry aTableEntry) {
		backlink         = aBacklink;
		this.EvaFunction = EvaFunction;
		this.bte         = aTableEntry;
	}

	public BaseTableEntry getBte() {
		return bte;
	}

	public void setBte(BaseTableEntry aBte) {
		bte = aBte;
	}
}
