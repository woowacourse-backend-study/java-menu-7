package menu.view;

import static menu.enums.InputMessage.INPUT_COACH_NAMES_MESSAGE;
import static menu.enums.InputMessage.INPUT_HATE_FOODS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.parser.CoachNameParser;
import menu.domain.parser.HateFoodsParser;

public class InputView {

    public List<String> inputCoachNames() {
        List<String> coachNames = null;

        while (coachNames == null) {
            System.out.println(INPUT_COACH_NAMES_MESSAGE.valueOf());
            coachNames = createCoachNames();
        }
        System.out.println();
        return coachNames;
    }

    private List<String> createCoachNames() {
        List<String> coachNames = null;
        try {
            coachNames = CoachNameParser.parse(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return coachNames;
    }

    public List<String> inputHateFoods(String name) {
        List<String> hateFoods = null;

        while (hateFoods == null) {
            System.out.println(name + INPUT_HATE_FOODS_MESSAGE.valueOf());
            hateFoods = createHateFoods();
        }
        return hateFoods;
    }

    private List<String> createHateFoods() {
        List<String> hateFoods = null;
        try {
            hateFoods = HateFoodsParser.parse(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return hateFoods;
    }
}
