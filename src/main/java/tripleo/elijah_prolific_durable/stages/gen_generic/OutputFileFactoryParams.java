package tripleo.elijah_prolific_durable.stages.gen_generic;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.logging.*;
import tripleo.elijah_prolific_durable.comp.*;
import tripleo.elijah_prolific_durable.lang.OS_Module;
import tripleo.elijah_prolific_durable.stages.logging.ElLog;

public class OutputFileFactoryParams {
	private final OS_Module       mod;
	private final ErrSink         errSink;
	private final ElLog.Verbosity verbosity;
	private final PipelineLogic   pipelineLogic;

	@Contract(pure = true)
	public OutputFileFactoryParams(final OS_Module aMod,
	                               final ErrSink aErrSink,
	                               final ElLog.Verbosity aVerbosity,
	                               final PipelineLogic aPipelineLogic) {
		mod           = aMod;
		errSink       = aErrSink;
		verbosity     = aVerbosity;
		pipelineLogic = aPipelineLogic;
	}

	public OS_Module getMod() {
		return mod;
	}

	public String getModFileName() {
		return mod.getFileName();
	}

	public ErrSink getErrSink() {
		return errSink;
	}

	public ElLog.Verbosity getVerbosity() {
		return verbosity;
	}

	public void addLog(final ElLog aLOG) {
		getPipelineLogic().addLog(aLOG);
	}

	public PipelineLogic getPipelineLogic() {
		return pipelineLogic;
	}
}
