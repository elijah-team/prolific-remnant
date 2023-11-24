package tripleo.elijah.stages.deduce.tastic;

import org.jdeferred2.Promise;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.DeduceTypes2;

public interface DT_External {
	//void run();

	OS_Module targetModule();

	void actualise(DeduceTypes2 aDt2);

	Promise<OS_Module, Void, Void> onTargetModulePromise();

	void tryResolve();
}
