package tripleo.elijah_prolific_durable.world.i;

import tripleo.elijah_prolific_durable.lang.OS_Module;
import tripleo.elijah_prolific_durable.nextgen.inputtree.EIT_ModuleInput;
import tripleo.elijah_prolific_durable.stages.deduce.DeducePhase;
import tripleo.elijah_prolific_durable.util.Eventual;

public interface WorldModule {
	OS_Module module();

	EIT_ModuleInput input();

//	GN_PL_Run2.GenerateFunctionsRequest rq();

	Eventual<DeducePhase.GeneratedClasses> getEventual();
}
