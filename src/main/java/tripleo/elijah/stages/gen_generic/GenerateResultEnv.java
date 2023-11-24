package tripleo.elijah.stages.gen_generic;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import tripleo.elijah.stages.gen_generic.pipeline_impl.GenerateResultSink;

import tripleo.elijah.work.WorkList;
import tripleo.elijah.work.WorkManager;

public record GenerateResultEnv(GenerateResultSink resultSink,
								GenerateResult gr,
								WorkManager wm,
								WorkList wl,
								GM_GenerateModule generateModule) {

	public GenerateFiles getGenerateFiles() {
		return generateModule().gmr().getGenerateFiles(() -> this);
	}

}
