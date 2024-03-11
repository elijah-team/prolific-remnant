/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang;

import java.util.*;

/**
 * Created 8/15/20 6:31 PM
 */
public class AnnotationClause {
	final List<AnnotationPart> aps = new ArrayList<AnnotationPart>();

	public void add(final AnnotationPart ap) {
		aps.add(ap);
	}
}

//
//
//
