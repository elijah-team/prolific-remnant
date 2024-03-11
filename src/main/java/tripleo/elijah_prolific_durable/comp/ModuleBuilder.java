package tripleo.elijah_prolific_durable.comp;

import tripleo.elijah_prolific_durable.contexts.ModuleContext;
import tripleo.elijah_prolific_durable.lang.OS_Module;
import tripleo.elijah_prolific_durable.nextgen.query.*;

public class ModuleBuilder {
	//		private final Compilation compilation;
	private final OS_Module mod;
	private       boolean   _addToCompilation = false;
	private       String    _fn               = null;

	public ModuleBuilder(final Compilation aCompilation) {
//			compilation = aCompilation;
		mod = new OS_Module();
		mod.setParent(aCompilation);
	}

	public ModuleBuilder setContext() {
		final ModuleContext mctx = new ModuleContext(mod);
		mod.setContext(mctx);
		return this;
	}

	public OS_Module build() {
		if (_addToCompilation) {
			if (_fn == null) throw new IllegalStateException("Filename not set in ModuleBuilder");
			mod.getCompilation().addModule(mod, _fn);
		}
		return mod;
	}

	public ModuleBuilder withPrelude(final String aPrelude) {
		final Operation2<OS_Module> p = mod.getCompilation().findPrelude(aPrelude);

		assert p.mode() == Mode.SUCCESS;

		mod.prelude = p.success();

		return this;
	}

	public ModuleBuilder withFileName(final String aFn) {
		_fn = aFn;
		mod.setFileName(aFn);
		return this;
	}

	public ModuleBuilder addToCompilation() {
		_addToCompilation = true;
		return this;
	}
}
