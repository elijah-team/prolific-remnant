package tripleo.elijah.stages.write_stage.pipeline_impl;

import org.jetbrains.annotations.NotNull;
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
import tripleo.elijah.nextgen.output.NG_OutputClass;
import tripleo.elijah.stages.gen_c.GenerateC;
import tripleo.elijah.stages.gen_fn.EvaClass;

class AmazingClass implements Amazing {
	private final OS_Module                        mod;
	private final Compilation                      compilation;
	private final WPIS_GenerateOutputs.OutputItems itms;
	private final EvaClass                         c;

	public AmazingClass(final @NotNull EvaClass c,
						final @NotNull WPIS_GenerateOutputs.OutputItems aOutputItems,
						final IPipelineAccess aPa) {
		this.c              = c;
		mod                 = c.module();
		compilation         = mod.getCompilation();
		itms                = aOutputItems;
	}

	void waitGenC(final GenerateC ggc) {
		var oc = new NG_OutputClass();
		oc.setClass(compilation.livingRepo().getClass(c).getGarish(), ggc);
		itms.addItem(oc);
	}

	public OS_Module mod() {
		return mod;
	}
}
