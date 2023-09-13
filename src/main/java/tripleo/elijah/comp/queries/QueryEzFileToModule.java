package tripleo.elijah.comp.queries;

import antlr.*;
import tripleo.elijah.ci.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.nextgen.query.*;
import tripleo.elijah.util.*;
import tripleo.elijjah.*;

import java.io.*;

public class QueryEzFileToModule {
	private final QueryEzFileToModuleParams params;

	public QueryEzFileToModule(final QueryEzFileToModuleParams aParams) {
		params = aParams;
	}

	public OS_Module load(final QueryDatabase qb) {
		throw new NotImplementedException();
	}

	public Operation<CompilerInstructions> calculate() {
		final String      f = params.sourceFilename;
		final InputStream s = params.inputStream;

		final EzLexer lexer = new EzLexer(s);
		lexer.setFilename(f);
		final EzParser parser = new EzParser(lexer);
		parser.setFilename(f);
		try {
			parser.program();
		} catch (RecognitionException aE) {
			return Operation.failure(aE);
		} catch (TokenStreamException aE) {
			return Operation.failure(aE);
		}
		final CompilerInstructions instructions = parser.ci;
		return Operation.success(instructions);
	}


}
