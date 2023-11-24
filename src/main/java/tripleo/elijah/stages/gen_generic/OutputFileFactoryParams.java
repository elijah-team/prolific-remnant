package tripleo.elijah.stages.gen_generic;

import org.jetbrains.annotations.Contract;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.logging.ElLog;

public class OutputFileFactoryParams {
	private final OS_Module       mod;
	private final ErrSink errSink;
	private final ElLog.Verbosity verbosity;
	private final PipelineLogic pipelineLogic;

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
