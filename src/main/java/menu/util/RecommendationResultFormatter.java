package menu.util;

import static menu.util.enums.ResultPattern.CATEGORY_PATTERN;
import static menu.util.enums.ResultPattern.RECOMMENDATION_MENUS_PATTERN;
import static menu.util.enums.ResultPattern.RESULT_DELIMITER;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.vo.Menu;
import menu.domain.RecommendationCategories;

public class RecommendationResultFormatter {

    private RecommendationResultFormatter() {}

    public static String formatRecommendationResult(Coaches coaches, RecommendationCategories categories) {
        return formatCategoryResult(categories) + formatRecommendMenusResult(coaches);
    }

    private static String formatCategoryResult(RecommendationCategories recommendationCategories) {

        List<String> categoryNames = convertCategories(recommendationCategories);

        return String.format(
                CATEGORY_PATTERN.getPattern(),
                String.join(RESULT_DELIMITER.getPattern(), categoryNames)
        );

    }

    private static String formatRecommendMenusResult(Coaches coaches) {
        StringBuilder builder = new StringBuilder();
        for (Coach coach : coaches.getCoaches()) {
            List<String> recommendationMenus = convertRecommendationMenus(coach);
            String formatted = String.format(
                    RECOMMENDATION_MENUS_PATTERN.getPattern(),
                    coach.getCoachName(),
                    String.join(RESULT_DELIMITER.getPattern(), recommendationMenus)
            );
            builder.append(formatted);
        }
        return builder.toString();
    }

    private static List<String> convertCategories(RecommendationCategories recommendationCategories) {
        return recommendationCategories.getRecommendationCategories()
                .stream()
                .map(Category::getName)
                .toList();
    }

    private static List<String> convertRecommendationMenus(Coach coach) {
        return coach.getRecommendationMenus()
                            .stream()
                            .map(Menu::getMenuName)
                            .toList();
    }

}
