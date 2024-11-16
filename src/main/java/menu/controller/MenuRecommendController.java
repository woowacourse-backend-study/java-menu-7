package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuOption;
import menu.domain.MenuRecommender;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {

    private static final int ZERO = 0;
    private static final int DAY_COUNT = 5;
    private final MenuRecommender recommender = new MenuRecommender();
    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<String> coachNames = inputView.inputCoaches();
        List<Coach> coachGroup = new ArrayList<>();

        for (String coachName : coachNames) {
            List<String> cannotEats = inputView.inputCannotEats(coachName);
            coachGroup.add(new Coach(coachName, cannotEats));
        }

        Coaches coaches = new Coaches(coachGroup);
        choiceCategory(coaches);

        outputView.showRecommendResult(coaches);
    }

    public void choiceCategory(Coaches coaches) {
        for (int day = ZERO; day < DAY_COUNT; day++) {
            MenuOption category = recommender.choiceCategory(coaches);
            choiceMenu(category, coaches);
        }
    }

    public void choiceMenu(MenuOption category, Coaches coaches) {
        for (Coach coach : coaches.getCoachGroup()) {
            recommender.choiceMenu(coach, category);
        }
    }
}
