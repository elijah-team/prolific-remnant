package tripleo.elijah.util;

import tripleo.elijah.util.Eventual;

public interface EventualRegister {
	<P> void register(Eventual<P> e);

	void checkFinishEventuals();
}
