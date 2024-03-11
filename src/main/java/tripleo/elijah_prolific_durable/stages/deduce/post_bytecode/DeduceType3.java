package tripleo.elijah_prolific_durable.stages.deduce.post_bytecode;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.comp.ErrSink;
import tripleo.elijah_prolific_durable.diagnostic.Diagnostic;
import tripleo.elijah_prolific_durable.lang.OS_Type;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceTypes2;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;

class DeduceType3 implements DED {
	private final OS_Type         osType;
	private final Diagnostic      diagnostic;
	private final IDeduceElement3 deduceElement3;
	private       GenType         _genType;

	public DeduceType3(final OS_Type aOSType, final Diagnostic aDiagnostic) {
		deduceElement3 = null;
		osType         = aOSType;
		diagnostic     = aDiagnostic;
	}

	public DeduceType3(final IDeduceElement3 aDeduceElement3, final OS_Type aOSType, final Diagnostic aDiagnostic1) {
		deduceElement3 = aDeduceElement3;
		osType         = aOSType;
		diagnostic     = aDiagnostic1;
	}

	public static IDeduceElement3 dispatch(final @NotNull VariableTableEntry aVariableTableEntry) {
		return aVariableTableEntry.getDeduceElement3();
	}

//	public static IDeduceElement3 dispatch(final @NotNull IdentTableEntry aIdentTableEntry) {
//		return aIdentTableEntry.getDeduceElement3(null/*aDeduceTypes2*/, null/*aGeneratedFunction*/);
//	}

//	public static IDeduceElement3 dispatch(final @NotNull ConstantTableEntry aConstantTableEntry) {
//		return aConstantTableEntry.getDeduceElement3();
//	}

	public static IDeduceElement3 dispatch(final IdentTableEntry aIdentTableEntry, final DeduceTypes2 aDeduceTypes2, final BaseGeneratedFunction aGeneratedFunction) {
		return aIdentTableEntry.getDeduceElement3(aDeduceTypes2, aGeneratedFunction);
	}

	@Override
	public Kind kind() {
		return Kind.DED_Kind_Type;
	}

	public void reportDiagnostic(final @NotNull ErrSink aErrSink) {
		assert isException();

		aErrSink.reportDiagnostic(diagnostic);
	}

	public boolean isException() {
		return diagnostic != null;
	}

	public GenType getGenType() {
		if (_genType == null) {
			_genType          = new GenType();
			_genType.resolved = osType;
		}

		return _genType;
	}
}
