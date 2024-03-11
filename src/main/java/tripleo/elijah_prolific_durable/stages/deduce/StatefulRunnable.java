package tripleo.elijah_prolific_durable.stages.deduce;

import tripleo.elijah_prolific_durable.stages.deduce.post_bytecode.DefaultStateful;

class StatefulRunnable extends DefaultStateful implements IStateRunnable {
	private final Runnable runnable;

	public StatefulRunnable(final Runnable aRunnable) {
		runnable = aRunnable;
	}

	public void run() {
		runnable.run();
	}
}
