package tripleo.elijah_prolific_durable.util;

public interface EventualRegister {
	<P> void register(Eventual<P> e);

	void checkFinishEventuals();
}
