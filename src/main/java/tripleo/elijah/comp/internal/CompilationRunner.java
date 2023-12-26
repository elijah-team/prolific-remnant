package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.*;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.*;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.*;
import tripleo.elijah.stateful.DefaultStateful;
import tripleo.elijah.stateful.State;
import tripleo.elijah.stateful.StateRegistrationToken;
import tripleo.elijah.stateful._RegistrationTarget;
import tripleo.elijah.util.Operation;
import tripleo.elijah.util.SimplePrintLoggerToRemoveSoon;

import java.util.function.Supplier;

public class CompilationRunner extends _RegistrationTarget {
	private final    Compilation _compilation;
	private @NotNull CCI         cci;
	private final    EzM         ezm = new EzM();
	private final          CR_State           __defer_CR_State;
	private final          ICompilationAccess __defer_CompilationAccess;
	public                 ICompilationBus    cb;
	public                 CR_State           crState;
	public @NotNull        IProgressSink      progressSink;
	CIS        cis;
	CR_FindCIs cr_find_cis;
	private CB_StartCompilationRunnerAction startAction;

	public CompilationRunner(final @NotNull ICompilationAccess aca, final CR_State aCrState, final Supplier<CompilationBus> scb) {
		_compilation = aca.getCompilation();

		this.__defer_CR_State          = aCrState;
		this.__defer_CompilationAccess = aca;

		cis = _compilation._cis();

		var cb1 = _compilation.getCompilationEnclosure().getCompilationBus();

		if (cb1 == null && scb != null) {
			cb = scb.get();
			_compilation.getCompilationEnclosure().setCompilationBus(cb);
		} else {
			cb = _compilation.getCompilationEnclosure().getCompilationBus();
		}
	}

	public void connect(final CK_ConnectionPlane aPlane) {
		aPlane.provide(this);

		aPlane.provide(__defer_CompilationAccess);
		aPlane.provide(__defer_CR_State); // [T060096]

		aPlane.onCrState ((CR_State aCrState) -> crState = aCrState);
		aPlane.onCCI     ((CCI      aCCI)     -> cci     = aCCI);

		progressSink = cb.defaultProgressSink();
		aPlane._defaultCCI(progressSink);

		CompilationRunner.ST.register(this);
	}

	public @NotNull Operation<CompilerInstructions> parseEzFile(final @NotNull SourceFileParserParams p) {
		final Operation<CompilerInstructions> oci = ezm.parseEzFile1(p);
		assert oci != null;

		_compilation.getInputTree().setNodeOperation(p.input(), oci);

		return oci;
	}

	public @NotNull Operation<CompilerInstructions> realParseEzFile(final @NotNull SourceFileParserParams p) {
		final Operation<CompilerInstructions> oci = ezm.realParseEzFile(p);

		_compilation.getInputTree().setNodeOperation(p.input(), oci);

		return oci;
	}

	public Compilation _accessCompilation() {
		return _compilation;
	}

	public CR_Action cr_find_cis() {
		if (this.cr_find_cis == null) {
			var beginning = _accessCompilation().beginning(this);
			this.cr_find_cis = new CR_FindCIs(beginning);
		} else {
			throw new UnintendedUseException(); // 12/17 FIXME figure this out plz (aka find the fix you already fixed)
		}
		return this.cr_find_cis;
	}

	public CCI _accessCCI() {
		return this.cci;
	}

	public void start(final CompilerInstructions ci, final @NotNull IPipelineAccess pa) {
		// FIXME only run once 06/16
		if (startAction == null) {
			startAction = new CB_StartCompilationRunnerAction(this, pa, ci);
			// FIXME CompilerDriven vs Process ('steps' matches "CK", so...)
			cb.add(startAction.cb_Process());
		}
	}

	public void logProgress(final int number, final String text) {
		if (number == 130) return;

		SimplePrintLoggerToRemoveSoon.println_err_3("%d %s".formatted(number, text));
	}

	public enum ST {
		;

		public static State EXIT_CONVERT_USER_TYPES;
		public static State EXIT_RESOLVE;
		public static State INITIAL;

		public static void register(final @NotNull _RegistrationTarget art) {
			//EXIT_RESOLVE            = registerState(new ST.ExitResolveState());
			INITIAL = art.registerState(new ST.InitialState());
			//EXIT_CONVERT_USER_TYPES = registerState(new ST.ExitConvertUserTypes());
		}

		static class ExitConvertUserTypes implements State {
			private StateRegistrationToken identity;

			@Override
			public void apply(final DefaultStateful element) {
				//final VariableTableEntry vte = ((DeduceElement3_VariableTableEntry) element).principal;

				//final DeduceTypes2         dt2     = ((DeduceElement3_VariableTableEntry) element).deduceTypes2();
			}

			@Override
			public boolean checkState(final DefaultStateful aElement3) {
				return true;
			}

			@Override
			public void setIdentity(final StateRegistrationToken aId) {
				identity = aId;
			}
		}

		static class ExitResolveState implements State {

			private StateRegistrationToken identity;

			@Override
			public void apply(final DefaultStateful element) {
				//final VariableTableEntry vte = ((DeduceElement3_VariableTableEntry) element).principal;
			}

			@Override
			public boolean checkState(final DefaultStateful aElement3) {
				//return ((DeduceElement3_VariableTableEntry) aElement3).st == DeduceElement3_VariableTableEntry.ST.INITIAL;
				return false; // FIXME
			}

			@Override
			public void setIdentity(final StateRegistrationToken aId) {
				identity = aId;
			}
		}

		static class InitialState implements State {
			private StateRegistrationToken identity;

			@Override
			public void apply(final DefaultStateful element) {

			}

			@Override
			public boolean checkState(final DefaultStateful aElement3) {
				return true;
			}

			@Override
			public void setIdentity(final StateRegistrationToken aId) {
				identity = aId;
			}
		}
	}
}
