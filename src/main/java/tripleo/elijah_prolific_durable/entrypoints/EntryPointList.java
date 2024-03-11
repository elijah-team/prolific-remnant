package tripleo.elijah_prolific_durable.entrypoints;

import org.jetbrains.annotations.*;
import tripleo.elijah_prolific_durable.stages.deduce.DeducePhase;
import tripleo.elijah_prolific_durable.stages.gen_fn.GenerateFunctions;
import tripleo.elijah_prolific_durable.work.*;

import java.util.*;
import java.util.function.Supplier;

public class EntryPointList {

	final @NotNull List<EntryPoint> eps;

	@Contract(pure = true)
	public EntryPointList() {
		eps = new ArrayList<>();
	}

	public void generate(@NotNull final GenerateFunctions aGenerateFunctions, final DeducePhase aDeducePhase, @NotNull final Supplier<WorkManager> wm) {
		generateFromEntryPoints(aDeducePhase, aGenerateFunctions, wm.get());
	}

	private void generateFromEntryPoints(final DeducePhase deducePhase,
	                                     final GenerateFunctions aGenerateFunctions,
	                                     final WorkManager wm) {
		if (eps.size() == 0) return; // short circuit


		final WorkList wl = new WorkList();

		for (final EntryPoint entryPoint : eps) {
			final EntryPointProcessor epp = EntryPointProcessor.dispatch(entryPoint, deducePhase, wl, aGenerateFunctions);
			epp.process();
		}

		wm.addJobs(wl);
		wm.drain();
	}

	public void add(final EntryPoint aEntryPoint) {
		eps.add(aEntryPoint);
	}

	public List<EntryPoint> _getMods() {
		return eps;
	}

	public int size() {
		return eps.size();
	}
}
