package tripleo.elijah.xlang;

import java.util.Objects;

import antlr.Token;
import tripleo.elijah.diagnostic.Locatable;

public interface LocatableString {
    public static LocatableString of(Token aToken) {
        return new LocatableString() {
            @Override
            public Locatable getLocatable() {
                return null;
            }

            @Override
            public String getString() {
                return aToken.getText();
            }

			@Override public boolean sameString(String string) { return Objects.equals(string, getString()); }
        };
    }

    Locatable getLocatable();

    String getString();

	boolean sameString(String aName);
}
