package menu.domain;

import static menu.util.enums.ErrorMessage.INVALID_COACH_NAME_LENGTH;

import java.util.Objects;

public class CoachName {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 4;

    private final String coachName;

    private CoachName(String name){
        this.coachName = name;
    }

    public static CoachName from(String name){
        validate(name);
        return new CoachName(name);
    }

    private static void validate(String input) {
        validateNameLength(input);
    }

    private static void validateNameLength(String input) {
        if (input.length() < MIN_LENGTH || input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH.getMessage());
        }
    }

    public String getCoachName() {
        return coachName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoachName coachName = (CoachName) o;
        return Objects.equals(this.coachName, coachName.coachName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coachName);
    }

    @Override
    public String toString() {
        return coachName;
    }

}
