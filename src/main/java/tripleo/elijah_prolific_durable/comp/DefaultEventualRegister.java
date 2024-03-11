package tripleo.elijah_prolific_durable.comp;

import tripleo.elijah_prolific_durable.util.Eventual;
import tripleo.elijah_prolific_durable.util.EventualRegister;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultEventualRegister implements EventualRegister {
    final List<Eventual<?>> _eventuals = new ArrayList<>();

    public DefaultEventualRegister() {
    }

    @Override
    public <P> void register(final Eventual<P> e) {
        _eventuals.add(e);
    }

    @Override
    public void checkFinishEventuals() {
        int y = 0;
        for (Eventual<?> eventual : _eventuals) {
            if (eventual.isResolved()) {
            } else {
                System.err.println("[DefaultEventualRegister::checkEventual] failed for " + eventual.description());
            }
        }
    }
}
