/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.ci_impl;

import antlr.Token;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.*;
import tripleo.elijah.lang.i.IExpression;
import tripleo.elijah.xlang.LocatableString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created 9/6/20 12:04 PM
 */
public class GenerateStatementImpl implements GenerateStatement {
	@Override
	public void addDirective(final @NotNull Token token, final IExpression expression) {
		dirs.add(new Directive(LocatableString.of(token), expression));
	}

	public final List<Directive> dirs = new ArrayList<Directive>();

	@Getter
	public static class Directive {
		private final IExpression expression;
		private final @NotNull LocatableString name;

		public Directive(final @NotNull LocatableString token_, final IExpression expression_) {
			name       = token_;
			expression = expression_;
		}

		public boolean sameName(String aName) {
			return Objects.equals(aName, this.name);
        }
    }
}

//
//
//
