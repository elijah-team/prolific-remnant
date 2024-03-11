/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tripleo.elijah_prolific_durable.nextgen.outputstatement;

import tripleo.elijah.nextgen.small.*;
import tripleo.elijah_prolific_durable.nextgen.small.*;

/**
 * @author Tripleo Nova
 */
public class EG_SyntheticStatement implements EG_Statement {

	private final EG_Naming naming;
	private final ES_Item   s;
	private final EX_Rule   rule;
	private       String    text;

	public EG_SyntheticStatement(final EG_Naming aNaming, final String aS, final EX_Rule aRule) {

		naming = aNaming;
		s      = new ES_String(aS);
		rule   = aRule;

		doNaming(naming, s);
	}

	private void doNaming(final EG_Naming aNaming, final ES_Item aS) {
		if (aNaming == null) return;

		final String ss = aNaming.s;
		final String s1 = aNaming.s1;

		if (ss.equals("include")) {
			if (s1.equals("local")) {
				final String text1 = ((ES_String) aS).getText();
				text = String.format("#include \"%s\"", text1);
			} else if (s1.equals("system") && ((ES_Symbol) aS).getText().equals("Prelude")) {
				final String text1 = ((ES_Symbol) aS).getText();
				text = String.format("#include \"%s.h\"", text1);
			}
		}
	}

	public EG_SyntheticStatement(final EG_Naming aNaming, final ES_Symbol aSymbol, final EX_Rule aRule) {
		naming = aNaming;
		s      = aSymbol;
		rule   = aRule;

		doNaming(naming, s);
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public EX_Explanation getExplanation() {
		return null;
	}

	public void setText(final String aS) {
		text = aS;
	}
}
