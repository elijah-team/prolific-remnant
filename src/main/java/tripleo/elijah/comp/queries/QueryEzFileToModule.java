package tripleo.elijah.comp.queries;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.CompilerInstructions;
import tripleo.elijah.ci_impl.*;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.query.QueryDatabase;
import tripleo.elijah.util.NotImplementedException;
import tripleo.elijah.util.Operation;
import tripleo.elijjah.EzLexer;
import tripleo.elijjah.EzParser;

import java.io.InputStream;

public class QueryEzFileToModule {
	private final QueryEzFileToModuleParams params;

	public QueryEzFileToModule(final QueryEzFileToModuleParams aParams) {
		params = aParams;
	}

	public @NotNull Operation<CompilerInstructions> calculate() {
		final String      f = params.sourceFilename;
		final InputStream s = params.inputStream;

		final EzLexer lexer = new EzLexer(s);
		lexer.setFilename(f);
		final EzParser parser = new EzParser(lexer);
		parser.setFilename(f);
		parser.pcon = new PCon();
		parser.ci   = //parser.pcon.newCompilerInstructionsImpl();
			new CompilerInstructionsBuilderImpl();
		try {
			parser.program();
		} catch (RecognitionException aE) {
			return Operation.failure(aE);
		} catch (TokenStreamException aE) {
			return Operation.failure(aE);
		}
		final CompilerInstructions instructions = parser.ci.build();
		return Operation.success(instructions);
	}

	public OS_Module load(final QueryDatabase qb) {
		throw new NotImplementedException();
	}
}
