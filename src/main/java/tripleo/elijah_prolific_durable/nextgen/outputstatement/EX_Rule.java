package tripleo.elijah_prolific_durable.nextgen.outputstatement;

public class EX_Rule implements EX_Explanation {
	private final String rule;

	public EX_Rule(final String aRule) {
		rule = aRule;
	}

	@Override
	public String getText() {
		return "EX_Rule "+rule;
	}
}
