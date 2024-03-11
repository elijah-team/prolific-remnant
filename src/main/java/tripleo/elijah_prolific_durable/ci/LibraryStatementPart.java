package tripleo.elijah_prolific_durable.ci;

import antlr.*;
import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.lang.IExpression;

public interface LibraryStatementPart {

	String getName();

	void setName(Token i1);

	String getDirName();

	void setDirName(Token dirName);

	void addDirective(Token token, IExpression iExpression);

	CompilerInstructions getInstructions();

	void setInstructions(CompilerInstructions instructions);

}