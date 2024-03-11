package tripleo.elijah_prolific_durable.comp.i;

public interface IProgressSink {
	void note(int aCode, ProgressSinkComponent aCci, int aType, Object[] aParams);
}
