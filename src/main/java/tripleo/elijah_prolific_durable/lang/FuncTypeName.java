package tripleo.elijah_prolific_durable.lang;

import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

import java.io.*;

/**
 * Created 8/16/20 2:16 AM
 */
public class FuncTypeName implements TypeName {
	private final Context       _ctx;
	private       TypeModifiers _modifiers;
	private       TypeNameList  _arglist     = null/*new TypeNameList()*/;
	private       TypeName      _returnValue = null /*new RegularTypeName()*/; // TODO warning

	public FuncTypeName(final Context cur) {
		_ctx = cur;
	}

	public void argList(final FormalArgList op) {
		final TypeNameList tnl = new TypeNameList();
		for (final FormalArgListItem fali : op.falis) {
			final TypeName tn = fali.typeName();
			if (tn != null)
				tnl.add(tn);
			else {
//				tnl.add(TypeName.Undeclared(fali)); // TODO implement me
			}
		}
		argList(tnl);
	}

	public void argList(final TypeNameList tnl) {
		_arglist = tnl;
	}

	//	@Override
	public void type(final TypeModifiers typeModifiers) {
		_modifiers = typeModifiers;
	}

	public void returnValue(final TypeName rtn) {
		_returnValue = rtn;
	}

	@Override
	public boolean isNull() {
		return _arglist == null && _returnValue == null;
	}

	@Override
	public Context getContext() {
		return _ctx;
	}

	@Override
	public void setContext(final Context context) {
		throw new NotImplementedException();
	}

	@Override
	public Type kindOfType() {
		return Type.FUNCTION;
	}

	@Override
	public int getLine() {
		return -1;
	}

	@Override
	public int getColumn() {
		return -1;
	}

	@Override
	public int getLineEnd() {
		return -1;
	}

	@Override
	public int getColumnEnd() {
		return -1;
	}

	@Override
	public File getFile() {
		return null;
	}
}

//
//
//