package tripleo.elijah.comp.i;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.IFunctionMapHook;
import tripleo.elijah.stages.logging.ElLog;

import java.util.List;

public interface ICompilationAccess {
	void addFunctionMapHook(IFunctionMapHook aFunctionMapHook);

	void addPipeline(final PipelineMember pl);

	List<IFunctionMapHook> functionMapHooks();

	Compilation getCompilation();

	Stages getStage();

	void setPipelineLogic(final PipelineLogic pl);

	ElLog.Verbosity testSilence();

	void writeLogs();

	Pipeline internal_pipelines();
}
