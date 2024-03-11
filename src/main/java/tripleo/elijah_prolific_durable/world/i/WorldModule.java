package tripleo.elijah_prolific_durable.world.i;

import tripleo.elijah.lang.*;
import tripleo.elijah.nextgen.inputtree.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah_prolific_durable.nextgen.inputtree.EIT_ModuleInput;
import tripleo.elijah_prolific_durable.stages.deduce.DeducePhase;
import tripleo.elijah_prolific_durable.util.Eventual;
import tripleo.elijah_prolific_durable.lang.OS_Module;

public interface WorldModule {
	OS_Module module();

	EIT_ModuleInput input();

//	GN_PL_Run2.GenerateFunctionsRequest rq();

	Eventual<DeducePhase.GeneratedClasses> getEventual();
}
