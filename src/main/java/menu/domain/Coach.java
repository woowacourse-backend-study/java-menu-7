package menu.domain;

import java.util.List;
import java.util.Objects;
import menu.error.ErrorMessage;

public class Coach {

    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;

    private final String name;
    private final List<String> hateFoods;

    public Coach(final String name, final List<String> hateFoods) {
        validate(name);
        this.name = name;
        this.hateFoods = hateFoods;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_LENGTH.valueOf());
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Coach coach)) {
            return false;
        }
        return Objects.equals(name, coach.name) && Objects.equals(hateFoods, coach.hateFoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hateFoods);
    }
}
