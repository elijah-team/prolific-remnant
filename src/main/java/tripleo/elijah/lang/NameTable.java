/**
 *
 */
package tripleo.elijah.lang;

import java.util.*;

/**
 * @author Tripleo
 * <p>
 * Created 	Mar 29, 2020 at 7:00:10 PM
 */
public class NameTable {

	final Map<String, TypedElement> members = new HashMap<String, TypedElement>();

	public void add(final OS_Element element, final String name, final OS_Type dtype) {
//		element.setType(dtype);
		members.put(name, new TypedElement(element, dtype));
		tripleo.elijah.util.Stupidity.println_err2("[NameTable#add] " + members);
	}

	class TypedElement {
		final OS_Element element;
		final OS_Type    type;

		public TypedElement(final OS_Element element2, final OS_Type dtype) {
			this.element = element2;
			this.type    = dtype;
		}

		@Override
		public String toString() {
			return "TypedElement{" +
			  "element=" + element +
			  ", type=" + type +
			  '}';
		}
	}

}

//
//
//
