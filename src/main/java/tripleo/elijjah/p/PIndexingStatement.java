package tripleo.elijjah.p;

import antlr.Token;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.comp.internal.Out;
import tripleo.elijah.lang.i.ExpressionList;
import tripleo.elijah.lang.i.IndexingItem;
import tripleo.elijah.lang.i.IndexingStatement;
import tripleo.elijah.lang.impl.IndexingStatementImpl;

/**
 * Unrealized intent: builder pattern
 * [11/24] idk why this is important
 */
public class PIndexingStatement implements IndexingStatement {
	private final IndexingStatementImpl carrier;

	public PIndexingStatement(final @NotNull Out aOut) {
		carrier = new IndexingStatementImpl(aOut.module());
	}

	@Override
	public void add(final IndexingItem i) {
		carrier.add(i);
	}

	@Override
	public void setExprs(final ExpressionList el) {
		carrier.setExprs(el);
	}

	@Override
	public void setName(final Token i1) {
		carrier.setName(i1);
	}

	public IndexingStatement build() {
		return carrier;
	}
}
