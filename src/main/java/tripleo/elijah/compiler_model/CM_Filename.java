package tripleo.elijah.compiler_model;

import java.io.File;

public interface CM_Filename {
    static CM_Filename fromFileToString(File file) {
        return new CM_Filename() {
            @Override
            public String getString() {
                return file.toString();
            }
        };
    }

    String getString();

	default File fileOf() {
      return new File(getString());
  }
}
