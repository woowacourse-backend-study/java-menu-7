package menu.domain;

import java.util.Objects;

public class Name {

    private final String text;

    public Name(final String text) {
        validate(text);
        this.text = text;
    }

    private void validate(String text) {
        if (text.length() < 2 || text.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2글자 이상 4글자 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Name name)) {
            return false;
        }
        return Objects.equals(text, name.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text;
    }
}
