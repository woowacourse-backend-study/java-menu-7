package menu.view;

import static menu.enums.OutputMessage.COMPLETE_MENU_RECOMMEND_MESSAGE;
import static menu.enums.OutputMessage.DAYS_MESSAGE;
import static menu.enums.OutputMessage.MENU_RECOMMEND_RESULT_MESSAGE;
import static menu.enums.OutputMessage.START_MENU_RECOMMEND_MESSAGE;

import menu.domain.Coaches;

public class OutputView {

    public void startService() {
        System.out.println(START_MENU_RECOMMEND_MESSAGE.valueOf());
    }

    public void showMenuRecommendResult(Coaches coaches) {
        System.out.println(MENU_RECOMMEND_RESULT_MESSAGE.valueOf());
        System.out.println(DAYS_MESSAGE.valueOf());
        System.out.println(coaches);
        System.out.println();
        System.out.println(COMPLETE_MENU_RECOMMEND_MESSAGE.valueOf());
    }
}
