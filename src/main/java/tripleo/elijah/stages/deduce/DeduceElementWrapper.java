package tripleo.elijah.stages.deduce;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public record DeduceElementWrapper(OS_Element element) {
	public boolean isNamespaceStatement() {
		return element instanceof NamespaceStatement;
	}
}
