package menu.domain;

import java.util.Arrays;
import java.util.List;
import menu.error.ErrorMessage;

public class MainParser {

    private static final String COACH_NAME_REGEX = "([가-힣]+)(,[가-힣]+)*";
    private static final String SEPARATOR = ",";
    private static final int MINIMUM_NUMBER_OF_COACHES = 2;
    private static final int MAXIMUM_NUMBER_OF_COACHES = 2;

    public static List<String> parseNameInput(String nameInput) {
        checkDividedSeparator(nameInput);

        String[] names = nameInput.split(SEPARATOR);
        checkNumberOfCoaches(names);

        return Arrays.asList(names);
    }

    public static List<String> parseHateFoodsInput(String hateFoods) {
        checkDividedSeparator(hateFoods);
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
