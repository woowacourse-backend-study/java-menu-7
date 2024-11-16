package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String enterCoach() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return readLine().strip();
    }
}
