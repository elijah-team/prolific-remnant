/**
 *
 */
package tripleo.elijah_prolific_durable.gen.nodes;

import org.eclipse.jdt.annotation.NonNull;
import tripleo.elijah_prolific_durable.comp.GenBuffer;
import tripleo.elijah_prolific_durable.gen.CompilerContext;
import tripleo.elijah_prolific_durable.lang.IdentExpression;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

import java.util.List;

/**
 * @author Tripleo(sb)
 *
 */
public class ClassDeclNode {

	public ClassDeclNode(final String string, final List modifiers, final List<Inherited> inheritance) {
		// TODO Auto-generated constructor stub
	}

	public void GenClassDecl(final CompilerContext cctx, final GenBuffer gbn) {
		// TODO Auto-generated method stub

	}

	public void CloseClassDecl(final CompilerContext cctx, final GenBuffer gbn) {
		// TODO Auto-generated method stub

	}

	public @NonNull IdentExpression type() {
		// TODO what is this
		throw new NotImplementedException();
	}

}
