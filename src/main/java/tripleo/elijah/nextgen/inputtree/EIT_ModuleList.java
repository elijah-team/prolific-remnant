package tripleo.elijah.nextgen.inputtree;

import org.jetbrains.annotations.*;
import tripleo.elijah.Eventual;
import tripleo.elijah.comp.*;
import tripleo.elijah.entrypoints.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.logging.*;
import tripleo.elijah.util.*;
import tripleo.elijah.work.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class EIT_ModuleList {
	private final List<OS_Module> mods;
//	private PipelineLogic __pl;

	@Contract(pure = true)
	public EIT_ModuleList(final List<OS_Module> aMods) {
		mods = aMods;
	}

	public List<OS_Module> getMods() {
		return mods;
	}

	public void process__PL(final Function<OS_Module, GenerateFunctions> ggf, final PipelineLogic pipelineLogic) {
		for (final OS_Module mod : mods) {
			final @NotNull EntryPointList epl = mod.entryPoints;

			if (epl.size() == 0) {
				continue;
			}


			final GenerateFunctions gfm = ggf.apply(mod);

			_process_PL__internal(pipelineLogic, mod, gfm, epl);
		}
	}

	public void process__PL2(final Function<OS_Module, Eventual<GenerateFunctions>> ggf, final PipelineLogic pipelineLogic) {
		for (final OS_Module mod : mods) {
			final @NotNull EntryPointList epl = mod.entryPoints;

			if (epl.size() == 0) {
				continue;
			}

			final Eventual<GenerateFunctions> functionsEventual = ggf.apply(mod);
			functionsEventual.then(gfm -> {
				_process_PL__internal(pipelineLogic, mod, gfm, epl);
			});
		}
	}

	private void _process_PL__internal(final PipelineLogic pipelineLogic, final OS_Module mod, final GenerateFunctions gfm, final @NotNull EntryPointList epl) {
		final DeducePhase deducePhase = pipelineLogic.dp;
		//final DeducePhase.@NotNull GeneratedClasses lgc            = deducePhase.generatedClasses;

		final _ProcessParams plp = new _ProcessParams(mod, pipelineLogic, gfm, epl, deducePhase);

		__process__PL__each(plp);
	}

	private void __process__PL__each(final @NotNull _ProcessParams plp) {
		final List<GeneratedNode> resolved_nodes = new ArrayList<GeneratedNode>();

		final OS_Module                    mod = plp.getMod();
		final DeducePhase.GeneratedClasses lgc = plp.getLgc();

		// assert lgc.size() == 0;

		final int size = lgc.size();

		if (size != 0) {
			NotImplementedException.raise();
			SimplePrintLoggerToRemoveSoon.println_err(String.format("lgc.size() != 0: %d", size));
		}

		plp.generate();

		//assert lgc.size() == epl.size(); //hmm

		final Coder coder = new Coder(plp.deducePhase.codeRegistrar);

		for (final GeneratedNode generatedNode : lgc) {
			coder.codeNodes(mod, resolved_nodes, generatedNode);
		}

		resolved_nodes.forEach(generatedNode -> coder.codeNode(generatedNode, mod));

		plp.deduceModule();

		PipelineLogic.resolveCheck(lgc);

//			for (final GeneratedNode gn : lgf) {
//				if (gn instanceof GeneratedFunction) {
//					GeneratedFunction gf = (GeneratedFunction) gn;
//					tripleo.elijah.util.Stupidity.println2("----------------------------------------------------------");
//					tripleo.elijah.util.Stupidity.println2(gf.name());
//					tripleo.elijah.util.Stupidity.println2("----------------------------------------------------------");
//					GeneratedFunction.printTables(gf);
//					tripleo.elijah.util.Stupidity.println2("----------------------------------------------------------");
//				}
//			}
	}

//	public void _set_PL(final PipelineLogic aPipelineLogic) {
//		__pl = aPipelineLogic;
//	}

	public Stream<OS_Module> stream() {
		return mods.stream();
	}

	public void add(final OS_Module m) {
		mods.add(m);
	}

	private static class _ProcessParams {
		private final OS_Module         mod;
		private final PipelineLogic     pipelineLogic;
		private final GenerateFunctions gfm;
		@NotNull
		private final EntryPointList    epl;
		private final DeducePhase       deducePhase;
//		@NotNull
//		private final ElLog.Verbosity                         verbosity;

		private _ProcessParams(@NotNull final OS_Module aModule,
		                       @NotNull final PipelineLogic aPipelineLogic,
		                       @NotNull final GenerateFunctions aGenerateFunctions,
		                       @NotNull final EntryPointList aEntryPointList,
		                       @NotNull final DeducePhase aDeducePhase) {
			mod           = aModule;
			pipelineLogic = aPipelineLogic;
			gfm           = aGenerateFunctions;
			epl           = aEntryPointList;
			deducePhase   = aDeducePhase;
//			verbosity = mod.getCompilation().pipelineLogic.getVerbosity();
		}

		@Contract(pure = true)
		public OS_Module getMod() {
			return mod;
		}

		public void generate() {
			epl.generate(gfm, deducePhase, getWorkManagerSupplier());
		}

		@Contract(pure = true)
		public @NotNull Supplier<WorkManager> getWorkManagerSupplier() {
			return () -> pipelineLogic.generatePhase.wm;
		}

		public void deduceModule() {
			deducePhase.deduceModule(mod, getLgc(), getVerbosity());
		}

		//
		//
		//

		@Contract(pure = true)
		public DeducePhase.GeneratedClasses getLgc() {
			return deducePhase.generatedClasses;
		}

		@Contract(pure = true)
		public ElLog.@NotNull Verbosity getVerbosity() {
			return pipelineLogic.getVerbosity();
		}

	}
}
