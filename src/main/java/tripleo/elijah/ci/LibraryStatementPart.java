package tripleo.elijah.ci;

import antlr.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public interface LibraryStatementPart {

	String getName();

	void setName(Token i1);

	String getDirName();

	void setDirName(Token dirName);

	void addDirective(Token token, IExpression iExpression);

	CompilerInstructions getInstructions();

	void setInstructions(CompilerInstructions instructions);

}