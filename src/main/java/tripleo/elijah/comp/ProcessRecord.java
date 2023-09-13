package tripleo.elijah.comp;

import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.stages.gen_generic.*;

import java.util.function.*;

public class ProcessRecord {
	public final PipelineLogic pipelineLogic;
	private final DeferredObject<GenerateResult, Void, Void> _pgr = new DeferredObject<>();
	AccessBus ab;

	public ProcessRecord(final @NotNull ICompilationAccess ca0) {
		ab = new AccessBus(ca0.getCompilation());

		ab.addPipelineLogic(PipelineLogic::new);
		ab.add(DeducePipeline::new);

		pipelineLogic = ab.__getPL();
	}

	public void writeLogs(final @NotNull ICompilationAccess ca) {
		ca.getStage().writeLogs(ca);
	}

	public void setGenerateResult(final GenerateResult gr) {
		_pgr.resolve(gr);
	}

	public void consumeGenerateResult(final @NotNull Consumer<Supplier<GenerateResult>> csgr) {
		csgr.accept(() -> {
			final GenerateResult[] xx = new GenerateResult[1];
			generateResultPromise().then((x) -> xx[0] = x);
			return xx[0];
		});
	}

	public Promise<GenerateResult, Void, Void> generateResultPromise() {
		return _pgr;
	}
}
