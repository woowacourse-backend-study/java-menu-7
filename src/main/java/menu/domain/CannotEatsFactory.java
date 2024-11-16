package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CannotEatsFactory {

    private static final String COACH_NAME_REGEX = "([가-힣]+)(,[가-힣]+)*";

    public static List<String> createCannotEats(String eats) {
        if (eats.isEmpty()) {
            return new ArrayList<>();
        }

        if (!eats.matches(COACH_NAME_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 콤마로 구분해야 합니다.");
        }

        String[] result = eats.split(",");
        checkExistsMenu(result);

        return Arrays.asList(result);
    }

    private static void checkExistsMenu(String[] result) {
        for (String food : result) {
            if (!MenuOption.isExistFood(food)) {
                throw new IllegalArgumentException("[ERROR] 존재하지 않는 음식입니다.");
            }
        }
    }
}
