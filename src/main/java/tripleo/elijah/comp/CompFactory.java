package tripleo.elijah.comp;

import org.jetbrains.annotations.Nullable;
import tripleo.elijah.ci.LibraryStatementPart;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.lang.i.Qualident;
import tripleo.elijah.nextgen.inputtree.EIT_ModuleInput;
import tripleo.elijah.util.Operation2;
import tripleo.elijah.world.i.WorldModule;

import java.io.File;
import java.util.List;

public interface CompFactory {
	EIT_ModuleInput createModuleInput(OS_Module aModule);

	Qualident createQualident(List<String> sl);

	InputRequest createInputRequest(File aFile, final @Nullable LibraryStatementPart aLsp);

	WorldModule createWorldModule(OS_Module aM);

	class InputRequest {
		private final File    _file;
		private final LibraryStatementPart    lsp;
		private       Operation2<WorldModule> op;

		public InputRequest(final File aFile, final @Nullable LibraryStatementPart aLsp) {
			_file   = aFile;
			lsp     = aLsp;
		}

		public File file() {
			return _file;
		}

		public boolean do_out() {
			return false;
		}

		public LibraryStatementPart lsp() {
			return lsp;
		}

		public void setOp(final Operation2<WorldModule> aOwm) {
			op = aOwm;
		}
	}
}
