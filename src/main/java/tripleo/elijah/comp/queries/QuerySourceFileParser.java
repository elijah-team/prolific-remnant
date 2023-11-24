package tripleo.elijah.comp.queries;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.util.Operation;

public class QuerySourceFileParser {
	private final CompilationRunner cr;

	public QuerySourceFileParser(final CompilationRunner aCr) {
		cr = aCr;
	}

	public Operation<CompilerInstructions> process(final @NotNull SourceFileParserParams p) {
		final Operation<CompilerInstructions> oci = cr.realParseEzFile(p);
		return oci;
	}
}
