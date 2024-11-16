package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoachesFactory {

    private static final String COACH_NAME_REGEX = "(\\w+)(,\\w+)*";
    private static final Pattern PATTERN = Pattern.compile(COACH_NAME_REGEX);

    public static Coaches createCoaches(String names) {
        List<Coach> coaches = new ArrayList<>();
        Matcher coachMatcher = PATTERN.matcher(names);

        if (!coachMatcher.find()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 콤마로 구분해야 합니다.");
        }

        String[] coachNames = names.split(",");

        for (String name : coachNames) {
            Coach coach = new Coach(new Name(name));
            coaches.add(coach);
        }

        return new Coaches(coaches);
    }
}
