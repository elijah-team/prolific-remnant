/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;

/**
 * Created 11/18/21 8:43 PM
 */
public class GenericElementHolderWithType implements IElementHolder {
	private final @NotNull OS_Element   element;
	private final          OS_Type      type;
	private final          DeduceTypes2 dt2;

	public GenericElementHolderWithType(final @NotNull OS_Element aElement,
	                                    final OS_Type aType,
	                                    final DeduceTypes2 aDeduceTypes2) {
		element = aElement;
		type    = aType;
		dt2     = aDeduceTypes2;
	}

	@Contract(pure = true)
	public GenericElementHolderWithType(final OS_Element aEle2, @NotNull final GenType aResult, final DeduceTypes2 aDeduceTypes2) {
		element = aEle2;
		type    = aResult.typeName; // TODO may be something stupid
		dt2     = aDeduceTypes2;
	}

	@Override
	public @NotNull OS_Element getElement() {
		return element;
	}

	public OS_Type getType() {
		return type;
	}

	public DeduceTypes2 getDeduceTypes2() {
		return dt2;
	}
}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
