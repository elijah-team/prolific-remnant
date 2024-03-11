package tripleo.elijah_prolific_durable.util;

import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class _ElTaggableMixin implements _ElTaggable {
    private final Map<Object, Object> exts = new HashMap<>();

    @Override
    public @Nullable Object getExt(Class<?> aClass) {
        if (exts.containsKey(aClass)) {
            return exts.get(aClass);
        }
        return null;
    }

    @Override
    public void putExt(Class<?> aClass, Object o) {
        exts.put(aClass, o);
    }
}