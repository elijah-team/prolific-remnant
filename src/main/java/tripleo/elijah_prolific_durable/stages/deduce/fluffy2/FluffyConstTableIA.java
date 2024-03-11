package tripleo.elijah_prolific_durable.stages.deduce.fluffy2;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceTypes2;
import tripleo.elijah_prolific_durable.stages.gen_fn.BaseGeneratedFunction;
import tripleo.elijah_prolific_durable.stages.gen_fn.ConstantTableEntry;
import tripleo.elijah_prolific_durable.stages.gen_fn.IdentTableEntry;
import tripleo.elijah_prolific_durable.stages.gen_fn.VariableTableEntry;
import tripleo.elijah_prolific_durable.stages.instructions.ConstTableIA;
import tripleo.elijah_prolific.deduce.*;

public class FluffyConstTableIA {
    private final ConstTableIA          cta;
    private final DeduceTypes2          deduceTypes2;
    private final BaseGeneratedFunction generatedFunction;

    public FluffyConstTableIA(ConstTableIA aConstTableIA, DeduceTypes2 aDeduceTypes2, BaseGeneratedFunction aBaseGeneratedFunction) {
        this.cta               = aConstTableIA;
        this.deduceTypes2      = aDeduceTypes2;
        this.generatedFunction = aBaseGeneratedFunction;
    }

    public void do_assign_constant(final PRD_Instruction aInstruction, final @NotNull VariableTableEntry aVariableTableEntry) {
        if (aVariableTableEntry.type.getAttached() != null) {
            // TODO check types
        }
        final @NotNull ConstantTableEntry cte = generatedFunction.getConstTableEntry(cta.getIndex());
        if (cte.type.getAttached() == null) {
            deduceTypes2._LOG().info("Null type in CTE " + cte);
        }
//		aVariableTableEntry.type = cte.type;
        aVariableTableEntry.addPotentialType(aInstruction.getIndex(), cte.type);

        aInstruction.putExt(FluffyRider.class, new _FluffyConstTableIA_DAC_Rider(aInstruction, aVariableTableEntry, null, this));
    }

    public void do_assign_constant(final PRD_Instruction aInstruction, final @NotNull IdentTableEntry aIdentTableEntry) {
        if (aIdentTableEntry.type != null && aIdentTableEntry.type.getAttached() != null) {
            // TODO check types
        }
        final @NotNull ConstantTableEntry cte = generatedFunction.getConstTableEntry(cta.getIndex());
        if (cte.type.getAttached() == null) {
            deduceTypes2._LOG().err("*** ERROR: Null type in CTE " + cte);
        }

        // aIdentTableEntry.type may be null, but we still addPotentialType here
        aIdentTableEntry.addPotentialType(aInstruction.getIndex(), cte.type);

        aInstruction.putExt(FluffyRider.class, new _FluffyConstTableIA_DAC_Rider(aInstruction, null, aIdentTableEntry, this));
    }
}
