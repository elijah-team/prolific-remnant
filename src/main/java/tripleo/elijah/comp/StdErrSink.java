/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
/**
 * Created Mar 25, 2019 at 3:00:39 PM
 */
package tripleo.elijah.comp;

import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.DebugFlags;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.util.SimplePrintLoggerToRemoveSoon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tripleo(sb)
 */
public class StdErrSink implements ErrSink {
    private final @NotNull List<Pair<Errors, Object>> _list = new ArrayList<>();
    private                int                        _errorCount;

    @Override
    public void exception(final Exception e) {
        _errorCount++;
        SimplePrintLoggerToRemoveSoon.println_err2("exception: " + e);
        e.printStackTrace(System.err);
    }

    private void reportError(String s, String s1) {
        reportError(String.format(s, s1));
    }

    @Override
    public int errorCount() {
        var ec = _list.stream().filter(x -> x.getLeft() == Errors.ERROR).count();
        assert ec == _errorCount;
        return _errorCount;
    }

    @Override
    public void info(final String message) {
        _list.add(Pair.of(Errors.INFO, message));
        if (DebugFlags.VOODOO) reportError("INFO: %s%n", message);
    }

    @Override
    public List<Pair<Errors, Object>> list() {
        return _list;
    }

    @Override
    public void reportDiagnostic(@NotNull Diagnostic diagnostic) {
        if (diagnostic.severity() == Diagnostic.Severity.ERROR)
            _errorCount++;
        if (DebugFlags.VOODOO)
            diagnostic.report(System.err);
        _list.add(Pair.of(Errors.DIAGNOSTIC, diagnostic));
        // 08/13 diagnostic.report(System.err);
    }

    @Override
    public void reportError(final String message) {
        _list.add(Pair.of(Errors.ERROR, message));

        _errorCount++;

        if (DebugFlags.VOODOO) reportError("ERROR: %s%n", message);
    }

    @Override
    public void reportWarning(final String message) {
        _list.add(Pair.of(Errors.WARNING, message));

        if (DebugFlags.VOODOO) reportError("WARNING: %s%n", message);
    }
}

//
//
//
