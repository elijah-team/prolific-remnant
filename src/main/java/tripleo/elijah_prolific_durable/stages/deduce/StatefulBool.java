package tripleo.elijah_prolific_durable.stages.deduce;

import tripleo.elijah_prolific_durable.stages.deduce.post_bytecode.DefaultStateful;

public class StatefulBool extends DefaultStateful {
	private boolean value;

	public boolean getValue() {
		return value;
	}

	public void setValue(final boolean aValue) {
		value = aValue;
	}
}
