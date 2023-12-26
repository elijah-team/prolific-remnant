package tripleo.elijah.comp.queries;

import java.io.InputStream;

public record QuerySourceFileToModuleParams(InputStream inputStream, String sourceFilename) { }
