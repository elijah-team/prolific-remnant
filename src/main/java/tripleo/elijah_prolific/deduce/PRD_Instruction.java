package tripleo.elijah_prolific.deduce;

import tripleo.elijah_prolific_durable.stages.deduce.fluffy2.Fluffy2Rider;
import tripleo.elijah_prolific_durable.stages.instructions.*;

public interface PRD_Instruction {
	int getIndex();

	InstructionName getName();

	InstructionArgument getArg(int aIndex);

	void putExt(Class<?> aFluffyRiderClass, Fluffy2Rider aFluffyRider);
}
