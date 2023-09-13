package tripleo.elijah.ut;

import tripleo.elijah.comp.*;
import tripleo.elijah.comp.i.*;

import java.util.*;

public class UT_Controller implements CompilerController {
	private final UT_Root     utr;
	List<String>    args;
	String[]        args2;
	ICompilationBus cb;
	private       Compilation c;

	public UT_Controller(final UT_Root aUtr) {
		utr = aUtr;
	}

	@Override
	public void printUsage() {
		System.out.println("Usage: eljc [--showtree] [-sE|O] <directory or .ez file names>");
	}

	@Override
	public void processOptions() {
		final OptionsProcessor             op  = new ApacheOptionsProcessor();
		final CompilerInstructionsObserver cio = new CompilerInstructionsObserver(c, op, c._cis);
		cb = new UT_CompilationBus(c, this);

		try {
			args2 = op.process(c, args, cb);
		} catch (final Exception e) {
			c.getErrSink().exception(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void runner() {
		try {
			c.__cr = new CompilationRunner(c, c._cis, cb, new IProgressSink() {
				@Override
				public void note(final int code, final ProgressSinkComponent component, final int type, final Object[] params) {
					if (component.isPrintErr(code, type)) {
						final String s = component.printErr(code, type, params);
						System.err.println(s);
					}
				}
			});
			c.__cr.doFindCIs(args2, cb);
		} catch (final Exception e) {
			c.getErrSink().exception(e);
			throw new RuntimeException(e);
		}
	}

	public void _set(final Compilation aCompilation, final List<String> aArgs) {
		c    = aCompilation;
		args = aArgs;
	}

	public List<ICompilationBus.CB_Action> actions() {
		return ((UT_CompilationBus) cb).actions;
	}

	public UT_CompilationBus cb() {
		return (UT_CompilationBus) cb;
	}
}
