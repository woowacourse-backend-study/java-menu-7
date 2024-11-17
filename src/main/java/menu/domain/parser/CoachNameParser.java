package menu.domain.parser;

import java.util.Arrays;
import java.util.List;
import menu.error.ErrorMessage;

public class CoachNameParser {

    private static final String COACH_NAME_REGEX = "([가-힣]+)(,[가-힣]+)*";
    private static final String SEPARATOR = ",";
    private static final int MINIMUM_NUMBER_OF_COACHES = 2;
    private static final int MAXIMUM_NUMBER_OF_COACHES = 5;
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;

    public static List<String> parse(String nameInput) {
        checkDividedSeparator(nameInput);

        String[] names = nameInput.split(SEPARATOR);
        checkNumberOfCoaches(names);
        checkCoachName(names);

        return Arrays.asList(names);
    }

    private static void checkCoachName(String[] names) {
        for (String name : names) {
            checkLength(name);
        }
    }

    private static void checkLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_LENGTH.valueOf());
        }
    }

    private static void checkNumberOfCoaches(String[] names) {
        if (names.length < MINIMUM_NUMBER_OF_COACHES || names.length > MAXIMUM_NUMBER_OF_COACHES) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_COACH.valueOf());
        }
    }

    private static void checkDividedSeparator(String nameInput) {
        if (!nameInput.matches(COACH_NAME_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.UNDIVIDED_NAME_BY_COMMA.valueOf());
        }
    }
}
