package tripleo.elijah.comp.internal;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.CD_CompilationRunnerStart;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.util.Mode;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

import java.util.ArrayList;
import java.util.List;

import static tripleo.elijah.util.Helpers.List_of;

public class CD_CompilationRunnerStart_1 implements CD_CompilationRunnerStart {
	private static boolean __REMOVE_ME_SOON__PROB_NOT_NECC = false;

	@Override
	public void start(final @NotNull CompilerInstructions aCompilerInstructions,
	                  final @NotNull CR_State crState,
	                  final @NotNull CB_Output out) {
		final Compilation                   compilation    = crState.ca().getCompilation();
		final Compilation.CompilationConfig cfg            = compilation.cfg();
		final CompilationEnclosure          ce             = compilation.getCompilationEnclosure();
		final CompilationRunner             cr             = ce.getCompilationRunner();
		final List<CompilerInput>           compilerInputs = ce.getCompilerInput();

		Preconditions.checkNotNull(cr);
		Preconditions.checkNotNull(cfg);

		// TODO 11/16 ca3??
		//  also this maybe wanted to be progressive (see other )
		final CompilerBeginning beginning = new CompilerBeginning(compilation, aCompilerInstructions, compilerInputs, cr.progressSink, cfg);

		// TODO 11/16 pa.notate (? -> prob)
		if (crState.started) {
			boolean should_never_happen = true;
			assert should_never_happen;
		} else {
			crState.started = true;
		}

		final CR_ProcessInitialAction f2                 = new CR_ProcessInitialAction(beginning);
		final CR_RunBetterAction      f4                 = new CR_RunBetterAction();

		final List<CR_Action>         crActionList       = List_of(f2, f4);
		final List<Operation<Ok>>     crActionResultList = new ArrayList<>(crActionList.size());

		if (!__REMOVE_ME_SOON__PROB_NOT_NECC) {
			var plane = crState.ca.getCompilation().getConnectionPlane();
			plane.onCompilationRunner(crState::setRunner);
		}

		for (final CR_Action each : crActionList) {
			each.attach(crState.runner());
			var res = each.execute(crState, out);
			crActionResultList.add(res);
		}

		for (int i = 0; i < crActionResultList.size(); i++) {
			final CR_Action     action           = crActionList.get(i);
			final Operation<Ok> booleanOperation = crActionResultList.get(i);

			final String s = ("5959 %s %b").formatted(action.name(), (booleanOperation.mode() == Mode.SUCCESS));
			out.logProgress(5959, s);
		}
	}
}
