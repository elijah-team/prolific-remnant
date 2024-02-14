package tripleo.elijah.stages.deduce.fluffy2;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.gen_fn.BaseGeneratedFunction;
import tripleo.elijah.stages.gen_fn.ConstantTableEntry;
import tripleo.elijah.stages.gen_fn.IdentTableEntry;
import tripleo.elijah.stages.gen_fn.VariableTableEntry;
import tripleo.elijah.stages.instructions.ConstTableIA;
import tripleo.elijah.stages.instructions.Instruction;

public class FluffyConstTableIA {
    private final ConstTableIA          cta;
    private final DeduceTypes2          deduceTypes2;
    private final BaseGeneratedFunction generatedFunction;

    public FluffyConstTableIA(ConstTableIA cta, DeduceTypes2 deduceTypes2, BaseGeneratedFunction aGf) {
        this.cta               = cta;
        this.deduceTypes2      = deduceTypes2;
        this.generatedFunction = aGf;
    }

    public void do_assign_constant(final @NotNull Instruction instruction, final @NotNull VariableTableEntry vte) {
        if (vte.type.getAttached() != null) {
            // TODO check types
        }
        final @NotNull ConstantTableEntry cte = generatedFunction.getConstTableEntry(cta.getIndex());
        if (cte.type.getAttached() == null) {
            deduceTypes2._LOG().info("Null type in CTE " + cte);
        }
//		vte.type = cte.type;
        vte.addPotentialType(instruction.getIndex(), cte.type);
    }

    public void do_assign_constant(final @NotNull Instruction instruction, final @NotNull IdentTableEntry idte) {
        if (idte.type != null && idte.type.getAttached() != null) {
            // TODO check types
        }
        final @NotNull ConstantTableEntry cte = generatedFunction.getConstTableEntry(cta.getIndex());
        if (cte.type.getAttached() == null) {
            deduceTypes2._LOG().err("*** ERROR: Null type in CTE " + cte);
        }
        // idte.type may be null, but we still addPotentialType here
        idte.addPotentialType(instruction.getIndex(), cte.type);
    }
}
