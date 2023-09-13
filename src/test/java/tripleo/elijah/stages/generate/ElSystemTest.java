/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */

package tripleo.elijah.stages.generate;

import org.junit.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah.util.*;

public class ElSystemTest {

	ElSystem    sys;
	Compilation c;
	private AccessBus ab;

	@Before
	public void setUp() throws Exception {
		c  = new CompilationImpl(new StdErrSink(), new IO());
		ab = new AccessBus(c);

		final String f = "test/basic1/backlink3";

		sys = new ElSystem();
		sys.setCompilation(c);

		c.feedCmdLine(Helpers.List_of(f));
	}

	@Test
	public void generateOutputs() {
		final OutputStrategy os = new OutputStrategy();
		os.per(OutputStrategy.Per.PER_CLASS);
		sys.setOutputStrategy(os);
		sys.generateOutputs(ab.gr);
	}
}

//
//
//
