package menu.controller;

import java.util.function.Supplier;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.RecommendationCategories;
import menu.domain.RecommendationMenuGenerator;
import menu.util.RecommendationResultFormatter;
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
        Coaches coaches = doLoop(this::registerCoach);
        RecommendationCategories recommendationCategories = RecommendationCategories.create();
        registerUnEatingMenus(coaches);
        generateRecommendationMenus(coaches, recommendationCategories);
        displayRecommendationResult(coaches, recommendationCategories);
    }


    private Coaches registerCoach() {
        String input = inputView.enterCoach();
        return Coaches.from(input);
    }

    private String getUnEatingMenus(Coach coach) {
        return inputView.enterUnEatingMenu(coach);
    }

    private void registerUnEatingMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            doLoop(() -> {
                String input = getUnEatingMenus(coach);
                coach.registerUnEatingMenus(input);
                return null;
            });
        }
    }

    private void generateRecommendationMenus(Coaches coaches, RecommendationCategories recommendationCategories) {
        RecommendationMenuGenerator recommendationMenuGenerator = RecommendationMenuGenerator.create(
                recommendationCategories);
        recommendationMenuGenerator.recommendationMenusGenerator(coaches);
    }

    private void displayRecommendationResult(Coaches coaches, RecommendationCategories categories) {
        String result = RecommendationResultFormatter.formatRecommendationResult(coaches, categories);
        outputView.printResult(result);
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
