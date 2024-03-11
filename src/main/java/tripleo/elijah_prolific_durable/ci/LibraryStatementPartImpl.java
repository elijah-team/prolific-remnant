/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.ci;

import antlr.*;
import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.lang.IExpression;

import java.util.*;

/**
 * Created 9/6/20 12:06 PM
 */
public class LibraryStatementPartImpl implements LibraryStatementPart {
	private String          name;
	private String          dirName;
	private List<Directive> dirs = null;

	private CompilerInstructions ci;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final Token i1) {
		name = i1.getText();
	}

	@Override
	public String getDirName() {
		return dirName;
	}

	@Override
	public void setDirName(final Token dirName) {
		this.dirName = dirName.getText();
	}

	@Override
	public void addDirective(final Token token, final IExpression iExpression) {
		if (dirs == null)
			dirs = new ArrayList<Directive>();
		dirs.add(new Directive(token, iExpression));
	}

	@Override
	public CompilerInstructions getInstructions() {
		return ci;
	}

	@Override
	public void setInstructions(final CompilerInstructions instructions) {
		ci = instructions;
	}

	public class Directive {

		private final IExpression expression;
		private final String      name;

		public Directive(final Token token_, final IExpression expression_) {
			name       = token_.getText();
			expression = expression_;
		}
	}

}

//
//
//
