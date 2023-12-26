package tripleo.elijah.compiler_model;

import tripleo.elijah.comp.CompFactory;
import tripleo.elijah.util.Mode;
import tripleo.elijah.util.Operation;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public interface CM_Filename {
	static CM_Filename fromFileToString(File specifiedAsFile) {
		return new CM_Filename() {
			@Override
			public String getString() {
				return specifiedAsFile.toString();
			}
			@Override public boolean sameString(String string) { return Objects.equals(string, getString()); }
		};
	}

	static CM_Filename fromParams(String specifiedAsString) {
		return new CM_Filename() {
			@Override
			public String getString() {
				return specifiedAsString;
			}
			@Override public boolean sameString(String string) { return Objects.equals(string, getString()); }
		};
	}

	static CM_Filename of(String specifiedAsString) {
		return new CM_Filename() {
			@Override
			public String getString() {
				return specifiedAsString;
			}
			@Override public boolean sameString(String string) { return Objects.equals(string, getString()); }
		};
	}

	static CM_Filename fromInputRequestCanonicalFileToString(CompFactory.InputRequest aInputRequest) {
		var r = fromInputRequestCanonicalFileToStringOperation(aInputRequest);
		if (r.mode() == Mode.SUCCESS) {
			return r.success();
		}
		throw new RuntimeException(r.failure());
	}

	static Operation<CM_Filename> fromInputRequestCanonicalFileToStringOperation(CompFactory.InputRequest aInputRequest) {
		var file = aInputRequest.file();
		var f = aInputRequest.file().toString();
		var do_out = aInputRequest.do_out();

		final String absolutePath1;
		try {
			absolutePath1 = file.getCanonicalFile().toString();
		} catch (IOException aE) {
			return Operation.failure(aE);
		}

		var r = CM_Filename.ofAbsolutePath(absolutePath1);
		return Operation.success(r);
	}

	static CM_Filename ofAbsolutePath(String specifiedAsAbsolutePath) {
		return new CM_Filename() {
			@Override
			public String getString() {
				return specifiedAsAbsolutePath;
			}

			@Override public boolean sameString(String string) { return Objects.equals(string, getString()); }
		};
	}

	String getString();

	default File fileOf() {
		return new File(getString());
	}

	default String printableString() {
		return getString();
	}

	boolean sameString(String string);
}
