package tripleo.elijah.comp.nextgen;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class CP_SubFile {
	private final           _CP_RootPath rootPath;
	private final @Nullable CP_Path      parentPath;
	private final           String       file;
	private final @NotNull  CP_Path      _path;

	public CP_SubFile(final _CP_RootPath aCPOutputPath, final String aFile) {
		rootPath   = aCPOutputPath;
		parentPath = null;
		file       = aFile;
		_path      = new CP_Path1(rootPath, file);
	}

	public CP_SubFile(final CP_Path aParentPath, final String aFile) {
		if (aParentPath instanceof _CP_RootPath)
			rootPath = (_CP_RootPath) aParentPath;
		else
			rootPath = aParentPath.getRootPath();

		parentPath = aParentPath;
		file       = aFile;
		_path      = new CP_Path1(rootPath, file);
	}

	public @NotNull File toFile() {
		return new File(file);
	}

	public CP_Path getPath() {
		return _path;
	}
}
