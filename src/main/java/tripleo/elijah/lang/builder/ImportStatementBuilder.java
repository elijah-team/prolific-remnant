/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.lang.builder;

import tripleo.elijah.contexts.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.*;

/**
 * Created 12/23/20 2:59 AM
 */
public class ImportStatementBuilder extends ElBuilder {
	// ASSIGNING
	List<AssigningImportStatement.Part> aparts = new ArrayList<AssigningImportStatement.Part>();
	// SELECTIVE/QUALIFIED
	List<QualifiedImportStatement.Part> sparts = new ArrayList<QualifiedImportStatement.Part>();
	// NORMAL
	List<Qualident> nparts = new ArrayList<Qualident>();
	private Context _context;
	private State   state;
	// ROOTED
	private Qualident     xy;
	private QualidentList qil;

	//
	//
	//

	public void addAssigningPart(final IdentExpression i1, final Qualident q1) {
		aparts.add(new AssigningImportStatement.Part(i1, q1));
		this.state = State.ASSIGNING;
	}

	public void addSelectivePart(final Qualident q3, final IdentList il) {
		sparts.add(new QualifiedImportStatement.Part(q3, il));
		this.state = State.SELECTIVE;
	}

	public void addNormalPart(final Qualident q2) {
		nparts.add(q2);
		this.state = State.NORMAL;
	}

	@Override
	protected ImportStatement build() {
		switch (state) {
		case ROOTED:
			final RootedImportStatement rootedImportStatement = new RootedImportStatement(_parent);
			rootedImportStatement.setRoot(xy);
			rootedImportStatement.setImportList(qil);
			rootedImportStatement.setContext(new ImportContext(_context, rootedImportStatement)); // TODO is this correct?
			return rootedImportStatement;
		case ASSIGNING:
			final AssigningImportStatement assigningImportStatement = new AssigningImportStatement(_parent);
			for (final AssigningImportStatement.Part apart : aparts) {
				assigningImportStatement.addPart(apart);
			}
			return assigningImportStatement;
		case SELECTIVE:
			final QualifiedImportStatement qualifiedImportStatement = new QualifiedImportStatement(_parent);
			for (final QualifiedImportStatement.Part spart : sparts) {
				qualifiedImportStatement.addPart(spart);
			}
			return qualifiedImportStatement;
		case NORMAL:
			final NormalImportStatement normalImportStatement = new NormalImportStatement(_parent);
			for (final Qualident npart : nparts) {
				normalImportStatement.addNormalPart(npart);
			}
			return normalImportStatement;
		}
		throw new IllegalStateException();
	}

	@Override
	protected void setContext(final Context context) {
		_context = context;
	}

	public void rooted(final Qualident xy, final QualidentList qil) {
		this.xy    = xy;
		this.qil   = qil;
		this.state = State.ROOTED;
	}

	enum State {
		ASSIGNING, SELECTIVE, NORMAL, ROOTED
	}
}

//
//
//
