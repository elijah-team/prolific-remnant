package tripleo.elijah.comp.internal;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public class DefaultProgressSink implements IProgressSink {
	@Override
	public void note(final int code, final ProgressSinkComponent component, final int type, final Object[] params) {
//		component.note(code, type, params);
		if (component.isPrintErr(code, type)) {
			final String s = component.printErr(code, type, params);
			System.err.println(s);
		}
	}
}
