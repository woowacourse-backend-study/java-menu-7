package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.CannotEatsFactory;
import menu.domain.CoachNamesFactory;

public class InputView {

    public List<String> inputCoaches() {
        List<String> coachNames = null;

        while (coachNames == null) {
            System.out.println("코치의 이름을 입력해주세요. (, 로 구분)");
            coachNames = getCoachNames(coachNames);
        }
        return coachNames;
    }

    private List<String> getCoachNames(List<String> coachNames) {
        try {
            coachNames = CoachNamesFactory.createCoaches(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return coachNames;
    }

    public List<String> inputCannotEats(String name) {
        List<String> hateMenus = null;

        while (hateMenus == null) {
            System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            hateMenus = getHateMenus(name, hateMenus);
        }
        return hateMenus;
    }

    private List<String> getHateMenus(String name, List<String> hateMenus) {
        try {
            hateMenus = CannotEatsFactory.createCannotEats(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return hateMenus;
    }

}
