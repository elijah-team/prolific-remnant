package tripleo.elijah_prolific.deduce;

import tripleo.elijah.stages.deduce.fluffy2.*;
import tripleo.elijah.stages.instructions.*;

public interface PRD_Instruction {
	int getIndex();

	InstructionName getName();

	InstructionArgument getArg(int aIndex);

	void putExt(Class<?> aFluffyRiderClass, Fluffy2Rider aFluffyRider);
}
