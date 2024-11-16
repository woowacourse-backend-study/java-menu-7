package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoachNamesFactory {

    private static final String COACH_NAME_REGEX = "([가-힣]+)(,[가-힣]+)*";

    public static List<String> createCoaches(String names) {
        checkDividedComma(names);

        String[] coachNames = names.split(",");
        checkCoachNumber(coachNames);

        return new ArrayList<>(Arrays.asList(coachNames));
    }

    private static void checkDividedComma(String names) {
        if (!names.matches(COACH_NAME_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 콤마로 구분해야 합니다.");
        }
    }

    private static void checkCoachNumber(String[] coachNames) {
        if (coachNames.length < 2 || coachNames.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 5명 이하여야 합니다.");
        }
    }
}
