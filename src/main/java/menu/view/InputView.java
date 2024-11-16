package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import menu.domain.Coach;

public class InputView {
    public String enterCoach() {
        println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return readLine().strip();
    }

    public String enterUnEatingMenu(Coach coach) {
        println();
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coach.getName());
        return readLine().strip();
    }

    private void println(){
        System.out.println();
    }
}
