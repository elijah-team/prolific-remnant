package tripleo.elijah_prolific_durable.comp.internal;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;
import tripleo.elijah_prolific_durable.comp.*;

public class ProcessRecord {
	public final AccessBus ab;

	public ProcessRecord(final @NotNull ICompilationAccess ca0) {
		ab = new AccessBus(ca0.getCompilation());

		ab.addPipelinePlugin(new GeneratePipelinePlugin());
		ab.addPipelinePlugin(new DeducePipelinePlugin());
		ab.addPipelinePlugin(new WritePipelinePlugin());
		ab.addPipelinePlugin(new WriteMesonPipelinePlugin());

		ab.addPipelineLogic(PipelineLogic::new);
//		ab.add(DeducePipeline::new);
	}

	public void writeLogs(final @NotNull ICompilationAccess ca) {
		//ab.writeLogs();
		ca.getStage().writeLogs(ca);
	}

	public interface PipelinePlugin {
		String name();

		PipelineMember instance(final @NotNull AccessBus ab0);
	}

	class GeneratePipelinePlugin implements PipelinePlugin {

		@Override
		public String name() {
			return "GeneratePipeline";
		}

		@Override
		public PipelineMember instance(final @NotNull AccessBus ab0) {
			return new GeneratePipeline(ab0);
		}
	}

	class DeducePipelinePlugin implements PipelinePlugin {

		@Override
		public String name() {
			return "DeducePipeline";
		}

		@Override
		public PipelineMember instance(final @NotNull AccessBus ab0) {
			return new DeducePipeline(ab0);
		}
	}

	class WritePipelinePlugin implements PipelinePlugin {
		@Override
		public String name() {
			return "WritePipeline";
		}

		@Override
		public PipelineMember instance(final @NotNull AccessBus ab0) {
			return new WritePipeline(ab0);
		}
	}

	class WriteMesonPipelinePlugin implements PipelinePlugin {
		@Override
		public String name() {
			return "WriteMesonPipeline";
		}

		@Override
		public PipelineMember instance(final @NotNull AccessBus ab0) {
			return new WriteMesonPipeline(ab0);
		}
	}

}
