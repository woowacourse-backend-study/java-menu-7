package menu.domain;

import static menu.util.enums.Delimiter.COMMA;
import static menu.util.enums.ErrorMessage.INVALID_COACHES_COUNT;
import static menu.util.enums.ErrorMessage.INVALID_DUPLICATION_COACH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Coaches {

    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 5;

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    public static Coaches from(String input) {
        String[] split = input.split(COMMA.getDelimiter(), -1);
        List<Coach> coaches = Arrays.stream(split).map(Coach::from).toList();
        return new Coaches(coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    private void validate(List<Coach> coaches) {
        validateSize(coaches);
        validateDuplication(coaches);
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < MIN_SIZE || coaches.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_COACHES_COUNT.getMessage());
        }
    }

    private void validateDuplication(List<Coach> coaches) {
        HashSet<Coach> uniqueCoaches = new HashSet<>(coaches);
        if (uniqueCoaches.size() != coaches.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_COACH.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Coaches{" +
                "coaches=" + coaches +
                '}';
    }

}
