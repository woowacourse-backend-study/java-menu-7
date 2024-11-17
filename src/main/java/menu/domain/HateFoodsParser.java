package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.error.ErrorMessage;

public class HateFoodsParser {

    private static final String COACH_NAME_REGEX = "([가-힣]+)(,[가-힣]+)*";
    private static final String SEPARATOR = ",";
    private static final int MAXIMUM_NUMBER_OF_FOODS = 2;

    public static List<String> parse(String hateFoodsInput) {
        if (hateFoodsInput.isEmpty()) {
            return new ArrayList<>();
        }
        checkDividedSeparator(hateFoodsInput);

        String[] hateFoods = hateFoodsInput.split(SEPARATOR);
        checkNumberOfFoods(hateFoods);

        return Arrays.asList(hateFoods);
    }

    private static void checkNumberOfFoods(String[] hateFoods) {
        if (hateFoods.length > MAXIMUM_NUMBER_OF_FOODS) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_HATE_FOODS.valueOf());
        }
    }

    private static void checkDividedSeparator(String hateFoodsInput) {
        if (!hateFoodsInput.matches(COACH_NAME_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.UNDIVIDED_NAME_BY_COMMA.valueOf());
        }
    }
}
