package tripleo.elijah.stages.deduce.fluffy2;

import tripleo.elijah.lang.Context;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.gen_fn.BaseGeneratedFunction;
import tripleo.elijah.stages.instructions.IdentIA;

public record Fluffy2ResolveOp(
        DeduceTypes2 deduceTypes2,
        Context ctx,
        IdentIA identIA,
        BaseGeneratedFunction generatedFunction,
        String explanation,
        Fluffy2Op upChain
) implements Fluffy2Op { }
