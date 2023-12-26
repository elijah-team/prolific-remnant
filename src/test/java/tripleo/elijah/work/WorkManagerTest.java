/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.work;

import org.junit.*;

import java.util.*;

public class WorkManagerTest {

	@Test
	public void testWorkManager() {
		final List<String> sink = new ArrayList<>();

		final WorkManager workManager = new WorkManager();

		final WorkList wl = new WorkList();
		wl.addJob(new AppendChar("A", 0, sink));
		wl.addJob(new AppendChar("B", 0, sink));
		wl.addJob(new AppendChar("C", 0, sink));

		workManager.addJobs(wl);

		workManager.drain();

		System.err.println(sink);
	}

	static class AppendChar implements WorkJob {

		private final int          level;
		private final List<String> sink;
		private final String       state;
		private       boolean      _done;

		public AppendChar(final String s, final int level, final List<String> aSink) {
			state      = s + (char) (level + 'A');
			this.level = level;
			sink       = aSink;
		}

		@Override
		public void run(final WorkManager aWorkManager) {
			if (level < 4) {
				final WorkList wl = new WorkList();
				wl.addJob(new AppendChar(state, level + 1, sink));
				aWorkManager.addJobs(wl);
			}
			sink.add(state);
			_done = true;
		}

		@Override
		public boolean isDone() {
			return _done;
		}
	}
}

//
//
//
