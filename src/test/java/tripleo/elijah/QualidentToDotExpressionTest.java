package tripleo.elijah;

import org.junit.*;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.util.Helpers;

public class QualidentToDotExpressionTest {

	@Test
	public void qualidentToDotExpression2() {
		final Qualident q = new Qualident();
		q.append(Helpers.string_to_ident("a"));
		q.append(Helpers.string_to_ident("b"));
		q.append(Helpers.string_to_ident("c"));
		final IExpression e = Helpers.qualidentToDotExpression2(q);
		System.out.println(e);
		Assert.assertEquals("a.b.c", e.toString());
	}
}