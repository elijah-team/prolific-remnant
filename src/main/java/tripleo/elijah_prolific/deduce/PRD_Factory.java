package tripleo.elijah_prolific.deduce;

import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.instructions.Instruction;

public class PRD_Factory {
	private final DeduceTypes2 deduceTypes2; // ??

	public PRD_Factory(final DeduceTypes2 aDeduceTypes2) {
		deduceTypes2 = aDeduceTypes2;
	}

	public PRD_Instruction newPRD_Instruction1(final Instruction aInstruction0) {
		return new PRD_Instruction1(aInstruction0);
	}
}
