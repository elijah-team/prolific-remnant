package tripleo.elijah.stages.deduce.nextgen;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.util.NotImplementedException;

public class DR_Type {
	private final BaseEvaFunction evaFunction;
	private final RegularTypeName nonGenericTypeName;
	private       IdentExpression base;

	public DR_Type(final BaseEvaFunction aEvaFunction, final TypeName aNonGenericTypeName) {
		evaFunction        = aEvaFunction;
		nonGenericTypeName = (RegularTypeName) aNonGenericTypeName;
	}

	public void build() {
		if (null == nonGenericTypeName) {
			NotImplementedException.raise();
		}

		if (nonGenericTypeName.getRealName().parts().size() == 1) {
			base = nonGenericTypeName.getRealName().parts().get(0);
			//base.getName().addUnderstanding(_inj().new_ENU_IsTypeName());
			base.getName().addUnderstanding(new ENU_IsTypeName());
		} else {
			throw new NotImplementedException();
		}

		for (TypeName typeName : nonGenericTypeName.getGenericPart().p()) {

		}
	}

	public void addUsage(EN_Usage us) {
		base.getName().addUsage(us);
	}
}
