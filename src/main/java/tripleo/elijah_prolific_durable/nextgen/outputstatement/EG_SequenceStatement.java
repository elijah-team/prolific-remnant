package tripleo.elijah_prolific_durable.nextgen.outputstatement;

import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.util.Helpers;

import java.util.*;
import java.util.stream.*;

public class EG_SequenceStatement implements EG_Statement {
	private final EG_Naming          naming;
	private final String             beginning;
	private final String             ending;
	private final List<EG_Statement> list;

	public EG_SequenceStatement(final EG_Naming aNaming, final List<EG_Statement> aList) {
		naming    = aNaming;
		list      = aList;
		beginning = null;
		ending    = null;
	}

	public EG_SequenceStatement(final EG_Naming aNaming, final String aNewBeginning, final String aNewEnding, final List<EG_Statement> aList) {
		naming    = aNaming;
		beginning = aNewBeginning;
		ending    = aNewEnding;
		list      = aList;
	}

	public EG_SequenceStatement(final String aBeginning, final String aEnding, final List<EG_Statement> aList) {
		beginning = aBeginning;
		ending    = aEnding;
		list      = aList;
		naming    = null;
	}

	@Override
	public String getText() {
		final String ltext = Helpers.String_join(" ", list.stream().map(st -> st.getText()).collect(Collectors.toList()));
		if (beginning != null) {
			return String.format("%s%s%s", beginning, ltext, ending);
		} else {
			return String.format("%s", ltext);
		}
	}

	@Override
	public EX_Explanation getExplanation() {
		return null;
	}

	public List<EG_Statement> _list() {
		return list;
	}
}
