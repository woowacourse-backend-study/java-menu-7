package menu.view;

import static menu.view.enums.OutputMessage.RESULT_FOOTER;
import static menu.view.enums.OutputMessage.RESULT_HEADER;
import static menu.view.enums.OutputMessage.RESULT_MESSAGE;
import static menu.view.enums.OutputMessage.START_MESSAGE;

public class OutputView {

    public void printStartMessage() {
        System.out.println(START_MESSAGE.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printResult(String recommendMenuResult) {
        System.out.println(RESULT_MESSAGE.getMessage());
        System.out.println(RESULT_HEADER.getMessage());
        System.out.println(recommendMenuResult);
        System.out.println(RESULT_FOOTER.getMessage());
    }
}
