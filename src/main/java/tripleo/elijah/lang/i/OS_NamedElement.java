/**
 *
 */
package tripleo.elijah.lang.i;

import org.jetbrains.annotations.Contract;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

/**
 * @author Tripleo
 * <p>
 * Created Mar 23, 2020 at 12:40:27 AM
 */
public interface OS_NamedElement {

	/**
	 * The name of the element TODO Should this be a {@link IdentExpression}?
	 *
	 * @return a String
	 */
	@Contract(pure = true)
	OS_ElementName name();

	EN_Name getEnName();
}

//
//
//
