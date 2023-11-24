package tripleo.elijah.lang.imports;

import tripleo.elijah.contexts.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.util.*;

import java.util.*;

/**
 * Created 8/7/20 2:10 AM
 */
public class NormalImportStatement extends _BaseImportStatement {
	final         OS_Element    parent;
	private final QualidentList importList = new QualidentList();
	private       Context       _ctx;

	public NormalImportStatement(final OS_Element aParent) {
		parent = aParent;
		if (parent instanceof OS_Container) {
			((OS_Container) parent).add(this);
		} else
			throw new NotImplementedException();
	}

	public void addNormalPart(final Qualident aQualident) {
		importList.add(aQualident);
	}

	@Override
	public Context getContext() {
		return parent.getContext();
	}

	@Override
	public OS_Element getParent() {
		return parent;
	}

	@Override
	public void setContext(final ImportContext ctx) {
		_ctx = ctx;
	}

	@Override
	public List<Qualident> parts() {
		return importList.parts;
	}

}

//
//
//
