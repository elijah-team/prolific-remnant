package tripleo.elijah_prolific_durable.comp.internal;

import tripleo.elijah.comp.i.*;
import tripleo.elijah_prolific_durable.comp.i.*;

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
