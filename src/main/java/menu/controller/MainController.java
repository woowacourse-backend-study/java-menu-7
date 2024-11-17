package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.RecommendMachine;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.startService();
        List<Coach> coachGroup = inputCoaches(inputView.inputCoachNames());
        Coaches coaches = createCoaches(coachGroup);

        progressRecommending(coaches, coachGroup);

        outputView.showMenuRecommendResult(coaches);
    }

    private List<Coach> inputCoaches(List<String> names) {
        List<Coach> coachGroup = new ArrayList<>();

        for (String name : names) {
            List<String> hateFoods = inputView.inputHateFoods(name);
            coachGroup.add(new Coach(name, hateFoods));
        }
        return coachGroup;
    }

    private Coaches createCoaches(List<Coach> coachGroup) {
        return new Coaches(coachGroup);
    }

    private void progressRecommending(Coaches coaches, List<Coach> coachGroup) {
        for (int day = 1; day <= 5; day++) {
            String categoryName = RecommendMachine.MACHINE.choiceCategory(coaches, Randoms.pickNumberInRange(1, 5));
            recommendMenu(coachGroup, categoryName);
        }
    }

    private void recommendMenu(List<Coach> coachGroup, String categoryName) {
        for (Coach coach : coachGroup) {
            String menuName = Randoms.shuffle(Category.findMenusByCategory(categoryName)).get(0);
            RecommendMachine.MACHINE.choiceMenu(categoryName, menuName, coach);
        }
    }
}
