/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.comp;

import java.util.*;

/**
 * Created 8/21/21 10:09 PM
 */
public class Pipeline {
	private final List<PipelineMember> pls = new ArrayList<>();
	private final ErrSink              errSink;

	public Pipeline(final ErrSink aErrSink) {
		errSink = aErrSink;
	}

	public void add(final PipelineMember aPipelineMember) {
		pls.add(aPipelineMember);
	}

	public void run() {
		try {
			for (final PipelineMember pl : pls) {
				pl.run();
			}
		} catch (final Exception e) {
			errSink.exception(e);
		}
	}
}

//
//
//
