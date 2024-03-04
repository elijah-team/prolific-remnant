package tripleo.elijah_prolific.deduce;

import tripleo.elijah.stages.deduce.fluffy2.Fluffy2Rider;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.util.NotImplementedException;

public class PRD_Instruction1 implements PRD_Instruction {
	private final Instruction carrier;

	public PRD_Instruction1(final Instruction aInstruction0) {
		this.carrier = aInstruction0;
	}

	@Override
	public int getIndex() {
		return this.carrier.getIndex();
	}

	@Override
	public InstructionName getName() {
		return this.carrier.getName();
	}

	@Override
	public InstructionArgument getArg(final int aIndex) {
		return this.carrier.getArg(aIndex);
	}

	@Override
	public void putExt(final Class<?> aFluffyRiderClass, final Fluffy2Rider aFluffyRider) {
		carrier.putExt(aFluffyRiderClass, aFluffyRider);
	}
}
