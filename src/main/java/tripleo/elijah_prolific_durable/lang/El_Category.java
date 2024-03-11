/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang;

import antlr.Token;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah_prolific_durable.util.Helpers;

/**
 * Created 3/26/21 4:47 AM
 */
public class El_Category {

	private final AccessNotation notation;

	public El_Category(final AccessNotation aNotation) {
		notation = aNotation;
	}

	@Nullable
	public String getCategoryName() {
		final Token category = notation.getCategory();
		if (category == null)
			return null;
		final String x = category.getText();
		return Helpers.remove_single_quotes_from_string(x);
	}
}

//
//
//
