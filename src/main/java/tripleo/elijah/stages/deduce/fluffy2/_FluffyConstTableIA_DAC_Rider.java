package tripleo.elijah.stages.deduce.fluffy2;

import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah_prolific.deduce.PRD_Instruction;

public record _FluffyConstTableIA_DAC_Rider(
		PRD_Instruction aInstruction,
		VariableTableEntry aVariableTableEntry,
		IdentTableEntry aIdentTableEntry,
		FluffyConstTableIA aFluffyConstTableIA
) implements Fluffy2Rider {
}
