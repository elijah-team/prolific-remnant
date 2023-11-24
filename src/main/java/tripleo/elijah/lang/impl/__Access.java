package tripleo.elijah.lang.impl;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public abstract class __Access implements ClassItem {
	private AccessNotation _an;

	@Override
	public AccessNotation getAccess() {
		return _an;
	}

	@Override
	public void setAccess(AccessNotation an) {
		_an = an;
	}

	@Override
	public void serializeTo(final SmallWriter sw) {

	}
}
