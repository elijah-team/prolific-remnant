package tripleo.elijah_prolific_durable.stages.deduce.fluffy2;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.lang.types.OS_UserClassType;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceTypes2;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;

public class FluffyClassStatement {
    private final ClassStatement        classStatement;
    private final DeduceTypes2          deduceTypes2;
    private final BaseGeneratedFunction generatedFunction;

    public FluffyClassStatement(final ClassStatement aCs, final DeduceTypes2 aDeduceTypes2, final BaseGeneratedFunction aGf) {
        classStatement    = aCs;
        deduceTypes2      = aDeduceTypes2;
        generatedFunction = aGf;
    }

    public void _foundElement_002(final ProcTableEntry pte, final VariableTableEntry vte, final int instructionIndex) {
        var kl = classStatement;

        @NotNull final OS_Type        type = new OS_UserClassType(kl);
        @NotNull final TypeTableEntry tte  = generatedFunction.newTypeTableEntry(TypeTableEntry.Type.TRANSIENT, type, pte.expression, pte);
        vte.addPotentialType(instructionIndex, tte);
        vte.setConstructable(pte);

        deduceTypes2.register_and_resolve(vte, kl);
    }
}
