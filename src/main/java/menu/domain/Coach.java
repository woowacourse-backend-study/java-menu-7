package menu.domain;

import java.util.Objects;

public class Coach {

    private String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String input) {
        String stripped = input.strip();
        validate(stripped);
        return new Coach(stripped);
    }

    private static void validate(String input) {
        validateNameLength(input);
    }

    private static void validateNameLength(String input) {
        if (input.length() < 2 || input.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치명은 최소 2글자 이상, 최대 4글자 이하 입력해야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coach coach)) {
            return false;
        }
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
