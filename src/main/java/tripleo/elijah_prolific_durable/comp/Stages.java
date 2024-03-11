package tripleo.elijah_prolific_durable.comp;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.comp.internal.ProcessRecord;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

public enum Stages {
	E("E") {
		@Override
		public void writeLogs(final ICompilationAccess aCompilationAccess) {
			NotImplementedException.raise();
		}

		@Override
		public RuntimeProcess getProcess(final ICompilationAccess aCa, final ProcessRecord aPr) {
			return new EmptyProcess(aCa, aPr);
		}
	},
	D("D") {
		@Override
		public void writeLogs(final ICompilationAccess aCompilationAccess) {
			aCompilationAccess.writeLogs();
		}

		@Override
		public @NotNull RuntimeProcess getProcess(final ICompilationAccess aCa, final ProcessRecord aPr) {
			return new DStageProcess(aCa, aPr);
		}
	},
	S("S") {
		@Override
		public void writeLogs(final ICompilationAccess aCompilationAccess) {
			aCompilationAccess.writeLogs();
		}

		@Override
		public RuntimeProcess getProcess(final ICompilationAccess aCa, final ProcessRecord aPr) {
			throw new NotImplementedException();
		}
	},  // ??
	O("O") {
		@Override
		public void writeLogs(final ICompilationAccess aCompilationAccess) {
			aCompilationAccess.writeLogs();
		}

		@Override
		public RuntimeProcess getProcess(final ICompilationAccess aCa, final ProcessRecord aPr) {
			return new OStageProcess(aCa, aPr);
		}
	}  // Output
	;

	private final String s;

	@Contract(pure = true)
	Stages(final String aO) {
		s = aO;
	}

	public abstract void writeLogs(final ICompilationAccess aCompilationAccess);

	public abstract RuntimeProcess getProcess(final ICompilationAccess aCa, final ProcessRecord aPr);
}
