package tripleo.elijah_prolific_durable.stages.deduce.fluffy2;

import tripleo.elijah_prolific_durable.lang.Context;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceTypes2;
import tripleo.elijah_prolific_durable.stages.gen_fn.BaseGeneratedFunction;
import tripleo.elijah_prolific_durable.stages.instructions.IdentIA;

public record Fluffy2ResolveOp(
        DeduceTypes2 deduceTypes2,
        Context ctx,
        IdentIA identIA,
        BaseGeneratedFunction generatedFunction,
        String explanation,
        Fluffy2Op upChain
) implements Fluffy2Op { }
