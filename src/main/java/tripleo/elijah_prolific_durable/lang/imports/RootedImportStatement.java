package tripleo.elijah_prolific_durable.lang.imports;

import tripleo.elijah_prolific_durable.contexts.ImportContext;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

import java.util.*;

/**
 * Created 8/7/20 2:09 AM
 */
public class RootedImportStatement extends _BaseImportStatement {
	final   OS_Element    parent;
	private QualidentList importList = new QualidentList(); // remove final for ImportStatementBuilder
	/**
	 * Used in from syntax
	 *
	 * @category from
	 */
	private Qualident     root;
	private Context       _ctx;

	public RootedImportStatement(final OS_Element aParent) {
		parent = aParent;
		if (parent instanceof OS_Container) {
			((OS_Container) parent).add(this);
		} else
			throw new NotImplementedException();
	}

	public Qualident getRoot() {
		return root;
	}

	public void setRoot(final Qualident root) {
		this.root = root;
	}

	/**
	 * Used in from syntax
	 *
	 * @category from
	 */
	public void importRoot(final Qualident xyz) {
		setRoot(xyz);
	}

	public QualidentList importList() {
		return importList;
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
		final List<Qualident> r = new ArrayList<Qualident>();
		for (final Qualident qualident : importList.parts) {
			final Qualident q = new Qualident();
			// TODO what the hell does this do? Should it be `root'
			for (final IdentExpression part : q.parts()) {
				q.append(part);
			}
			for (final IdentExpression part : qualident.parts()) {
				q.append(part);
			}
			r.add(q);
		}
		return r;
	}

	public void setImportList(final QualidentList qil) {
		importList = qil;
	}
}

//
//
//
