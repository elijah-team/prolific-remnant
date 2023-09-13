/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.lang.builder;

import antlr.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.util.*;

import java.util.*;

/**
 * Created 12/23/20 12:49 AM
 */
public class BaseScope implements Documentable {
	protected final List<ElBuilder> bs = new ArrayList<ElBuilder>();
	private final List<Token> _docstrings = new ArrayList<Token>();

	public void return_expression(final IExpression expr) {
		throw new NotImplementedException();
	}

	public void add(final ElBuilder b) {
		bs.add(b);
	}

	@Override
	public void addDocString(final Token s1) {
		_docstrings.add(s1);
	}

	public void continue_statement() {
		throw new NotImplementedException();
	}

	public void break_statement() {
		throw new NotImplementedException();
	}

	public void statementWrapper(final IExpression expr) {
		throw new NotImplementedException();
	}

	public Iterable<ElBuilder> items() {
		return bs;
	}

	public void constructExpression(final Qualident q, final ExpressionList o) {
		throw new NotImplementedException();
	}

	public void yield(final IExpression expr) {
		throw new NotImplementedException();
	}
}

//
//
//
