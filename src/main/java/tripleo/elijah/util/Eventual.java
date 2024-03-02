package tripleo.elijah.util;

import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.diagnostic.*;

public class Eventual<P> {
	private final DeferredObject<P, Diagnostic, Void> prom = new DeferredObject<>();

	public void resolve(final P p) {
		prom.resolve(p);
	}

	public void then(final DoneCallback<? super P> cb) {
		prom.then(cb);
	}

	public void register(final @NotNull EventualRegister ev) {
		ev.register(this);
	}

	public void fail(final Diagnostic d) {
		prom.reject(d);
	}

	public boolean isResolved() {
		return prom.isResolved();
	}

	/**
	 * Please overload this
	 */
	public String description() {
		return "GENERIC-DESCRIPTION";
	}

    public boolean isFailed() {
		return prom.isRejected();
    }

	public boolean isPending() {
		return prom.isPending();
	}
}
