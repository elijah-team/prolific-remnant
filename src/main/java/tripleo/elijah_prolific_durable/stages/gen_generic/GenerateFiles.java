package tripleo.elijah_prolific_durable.stages.gen_generic;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.nextgen.model.SM_Node;
import tripleo.elijah_prolific_durable.stages.gen_fn.GeneratedNode;
import tripleo.elijah_prolific_durable.work.WorkManager;

import java.util.*;

public interface GenerateFiles extends CodeGenerator {

	GenerateResult generateCode(final @NotNull Collection<GeneratedNode> aNodeCollection, final @NotNull WorkManager aWorkManager);

	void forNode(final SM_Node aNode);

	GenerateResult resultsFromNodes(List<GeneratedNode> aNodes, WorkManager aWm);
}
