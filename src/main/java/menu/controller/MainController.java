package menu.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Supplier;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.RecommendationMenuGenerator;
import menu.domain.UnEatingMenusMapper;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void process() {
        outputView.printStartMessage();

        Coaches coaches = doLoop(this::getCoachNames);

        UnEatingMenusMapper unEatingMenusMapper = generateUnEatingMenusMapper(coaches);

        RecommendationMenuGenerator recommendationMenuGenerator = new RecommendationMenuGenerator();
        LinkedHashMap<Coach, List<Menu>> coachListLinkedHashMap = recommendationMenuGenerator.recommendationMenusGenerator(
                coaches, unEatingMenusMapper);

        List<String> matchesCategoryNames = Category.getMatchesCategoryNames(
                coachListLinkedHashMap.get(coaches.getCoaches().getFirst()));

        outputView.printResult(
                displayCategoryResult(matchesCategoryNames),
                displayRecommendMenuResult(coachListLinkedHashMap)
        );
    }

    private String displayCategoryResult(List<String> matchesCategoryNames) {
        return String.format("[ 카테고리 | %s | %s | %s | %s | %s ]",
                matchesCategoryNames.get(0),
                matchesCategoryNames.get(1),
                matchesCategoryNames.get(2),
                matchesCategoryNames.get(3),
                matchesCategoryNames.get(4)
        );
    }

    private String displayRecommendMenuResult(LinkedHashMap<Coach, List<Menu>> coachListLinkedHashMap) {
        StringBuilder builder = new StringBuilder();
        Set<Entry<Coach, List<Menu>>> entries = coachListLinkedHashMap.entrySet();
        for (Entry<Coach, List<Menu>> entry : entries) {
            String formatted = String.format("[ %s | %s | %s | %s | %s | %s ]\n",
                    entry.getKey().getName(),
                    entry.getValue().get(0),
                    entry.getValue().get(1),
                    entry.getValue().get(2),
                    entry.getValue().get(3),
                    entry.getValue().get(4)
            );
            builder.append(formatted);
        }
        return builder.toString();
    }

    private Coaches getCoachNames() {
        String input = inputView.enterCoach();
        return Coaches.from(input);
    }

    private Menus getUnEatingMenus(Coach coach) {
        String input = inputView.enterUnEatingMenu(coach);
        return Menus.createUnEatingMenusFrom(input);
    }

    private UnEatingMenusMapper generateUnEatingMenusMapper(Coaches coaches) {
        Map<Coach, Menus> unEatingMenus = new HashMap<>();
        for (Coach coach : coaches.getCoaches()) {
            Menus menus = doLoop(() -> getUnEatingMenus(coach));
            unEatingMenus.put(coach, menus);
        }
        return UnEatingMenusMapper.from(unEatingMenus);
    }

    private <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
