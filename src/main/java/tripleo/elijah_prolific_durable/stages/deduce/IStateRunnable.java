package tripleo.elijah_prolific_durable.stages.deduce;

import tripleo.elijah.stages.deduce.post_bytecode.*;
import tripleo.elijah_prolific_durable.stages.deduce.post_bytecode.*;

public interface IStateRunnable extends Stateful {
	void run();

	class ST {
		public static State EXIT_RUN;

		public static void register(final DeducePhase aDeducePhase) {
			EXIT_RUN = aDeducePhase.register(new ExitRunState());
		}

		private static class ExitRunState implements State {
			private boolean runAlready;

			@Override
			public void apply(final DefaultStateful element) {
//				boolean b = ((StatefulBool) element).getValue();
				if (!runAlready) {
					runAlready = true;
					((StatefulRunnable) element).run();
				}
			}

			@Override
			public void setIdentity(final int aId) {

			}

			@Override
			public boolean checkState(final DefaultStateful aElement3) {
				return true;
			}

		}

	}
}
