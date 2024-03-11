/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang;

import com.google.common.base.*;
import com.google.common.collect.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.util.Helpers;

import java.util.*;

public class TypeNameList {

	final List<TypeName> p = new ArrayList<TypeName>();

	public void add(final TypeName tn) {
		p.add(tn);
	}

	public TypeName get(final int index) {
		return p.get(index);
	}

	public int size() {
		return p.size();
	}

	@Override
	public String toString() {
		return Helpers.String_join(", ", Collections2.transform(p, new Function<TypeName, String>() {
			@Nullable
			@Override
			public String apply(@Nullable final TypeName input) {
				assert input != null;
				return input.toString();
			}
		}));
	}
}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
