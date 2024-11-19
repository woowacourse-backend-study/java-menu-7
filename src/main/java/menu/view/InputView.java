package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.view.enums.InputMessage.ENTER_COACH_NAME_MESSAGE;
import static menu.view.enums.InputMessage.ENTER_UN_EATING_MENU_MESSAGE;

import menu.domain.Coach;

public class InputView {

    public String enterCoach() {
        println();
        System.out.println(ENTER_COACH_NAME_MESSAGE.getMessage());
        return readLine().strip();
    }

    public String enterUnEatingMenu(Coach coach) {
        println();
        System.out.printf(ENTER_UN_EATING_MENU_MESSAGE.getMessage(), coach.getCoachName());
        return readLine().strip();
    }

    private void println(){
        System.out.println();
    }
}
