package tripleo.elijah_prolific_durable.world.impl;

import tripleo.elijah.lang.*;
import tripleo.elijah.world.i.*;
import tripleo.elijah_prolific_durable.lang.OS_Package;
import tripleo.elijah_prolific_durable.world.i.LivingPackage;

public class DefaultLivingPackage implements LivingPackage {
	private final OS_Package _element;

	public DefaultLivingPackage(final OS_Package aElement) {
		_element = aElement;
	}

	@Override
	public OS_Package getElement() {
		return _element;
	}

	@Override
	public int getCode() {
		return 0;
	}
}
