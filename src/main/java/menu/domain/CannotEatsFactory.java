package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CannotEatsFactory {

    private static final String COACH_NAME_REGEX = "(\\w+)(,\\w+)*";
    private static final Pattern PATTERN = Pattern.compile(COACH_NAME_REGEX);

    public static List<String> createCannotEats(String eats) {
        if (eats.isEmpty()) {
            return new ArrayList<>();
        }

        Matcher coachMatcher = PATTERN.matcher(eats);

        if (!coachMatcher.find()) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 콤마로 구분해야 합니다.");
        }

        String[] result = eats.split(",");

        return Arrays.asList(result);
    }
}
