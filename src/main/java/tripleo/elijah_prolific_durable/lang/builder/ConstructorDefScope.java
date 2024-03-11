/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang.builder;

import antlr.Token;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

import java.util.*;


//

/**
 * Created 12/22/20 11:26 PM
 */
public class ConstructorDefScope extends BaseFunctionDefScope implements Documentable /*extends FunctionDefScope*/ {
	//	private List<ElBuilder> _items = new ArrayList<ElBuilder>();
	private final List<Token> docstrings = new ArrayList<Token>();

//	@Override
//	public Iterable<ElBuilder> items() {
//		return _items;
//	}

	@Override
	public void addDocString(final Token s1) {
		docstrings.add(s1);
	}

	@Override
	public void continue_statement() {
		throw new NotImplementedException();
	}

	@Override
	public void break_statement() {
		throw new NotImplementedException();
	}

	@Override
	public void statementWrapper(final IExpression expr) {
		add(new StatementWrapperBuilder(expr));
	}

	@Override
	public void yield(final IExpression expr) {
		throw new NotImplementedException();
	}
}
//
//
