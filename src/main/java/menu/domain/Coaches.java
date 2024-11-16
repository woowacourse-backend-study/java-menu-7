package menu.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    public static Coaches from(String input) {
        String[] split = input.split(",", -1);
        List<Coach> coaches = Arrays.stream(split).map(Coach::from).toList();
        return new Coaches(coaches);
    }

    private void validate(List<Coach> coaches) {
        validateSize(coaches);
        validateDuplication(coaches);
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상, 최대 5명 이하 입력해야 합니다.");
        }
    }

    private void validateDuplication(List<Coach> coaches) {
        HashSet<Coach> uniqueCoaches = new HashSet<>(coaches);
        if (uniqueCoaches.size() != coaches.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 코치명을 입력할 수 없습니다.");
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    @Override
    public String toString() {
        return "Coaches{" +
                "coaches=" + coaches +
                '}';
    }
}
