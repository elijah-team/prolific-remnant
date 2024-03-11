package tripleo.elijah_prolific_durable.stages.deduce.fluffy2;

import tripleo.elijah_prolific.deduce.PRD_Instruction;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;

public record _FluffyConstTableIA_DAC_Rider(
		PRD_Instruction aInstruction,
		VariableTableEntry aVariableTableEntry,
		IdentTableEntry aIdentTableEntry,
		FluffyConstTableIA aFluffyConstTableIA
) implements Fluffy2Rider {
}
