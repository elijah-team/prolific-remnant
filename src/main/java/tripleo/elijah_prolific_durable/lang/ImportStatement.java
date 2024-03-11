/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang;

import tripleo.elijah.contexts.*;
import tripleo.elijah.lang2.*;
import tripleo.elijah_prolific_durable.contexts.ImportContext;
import tripleo.elijah_prolific_durable.lang2.ElElementVisitor;

import java.util.*;

public interface ImportStatement extends ModuleItem, ClassItem, StatementItem {

	@Override
	default void visitGen(final ElElementVisitor visit) {
		visit.visitImportStatment(this);
	}

	List<Qualident> parts();

	void setContext(ImportContext ctx);
}

//
//
//
