package tripleo.elijah_prolific_durable.nextgen.outputstatement;

import org.jetbrains.annotations.*;
import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.util.Helpers;

import java.util.*;

public class EG_DottedStatement implements EG_Statement {
	private final String         separator;
	private final List<String>   stringList;
	private final EX_Explanation explanation;

	public EG_DottedStatement(final String aSeparator, final List<String> aStringList, final EX_Explanation aExplanation) {
		separator   = aSeparator;
		stringList  = aStringList;
		explanation = aExplanation;
	}

	@Override
	public @NotNull String getText() {
		return Helpers.String_join(separator, stringList);
	}

	@Override
	public EX_Explanation getExplanation() {
		return explanation;
	}
}
