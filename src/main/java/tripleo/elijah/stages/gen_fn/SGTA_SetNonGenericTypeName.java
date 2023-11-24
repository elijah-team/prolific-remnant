package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action_Arena;

public class SGTA_SetNonGenericTypeName implements setup_GenType_Action {
	private final @NotNull TypeName typeName;

	public SGTA_SetNonGenericTypeName(final @NotNull TypeName aTypeName) {
		typeName = aTypeName;
	}

	@Override
	public void run(final @NotNull GenType gt, final @NotNull setup_GenType_Action_Arena arena) {
		gt.setNonGenericTypeName(typeName);
	}
}
