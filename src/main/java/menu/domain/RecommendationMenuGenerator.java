package menu.domain;

import java.util.List;
import menu.domain.vo.Menu;

public class RecommendationMenuGenerator {

    private static final int MAX_SIZE = 5;

    private final RecommendationCategories recommendCategories;

    private RecommendationMenuGenerator(RecommendationCategories recommendCategories) {
        this.recommendCategories = recommendCategories;
    }

    public static RecommendationMenuGenerator create(RecommendationCategories recommendCategories) {
        return new RecommendationMenuGenerator(recommendCategories);
    }

    public void recommendationMenusGenerator(Coaches coaches) {
        while (recommendCategories.getSize() < MAX_SIZE) {
            Category randomCategory = Category.getRandomCategory();
            if (recommendCategories.checkRegistrable(randomCategory)) {
                recommendCategories.addRecommendationCategories(randomCategory);
                generateRandomMenu(randomCategory, coaches);
            }
        }
    }

    private void generateRandomMenu(Category category, Coaches coaches) {
        List<Coach> getCoaches = coaches.getCoaches();
        for (Coach coach : getCoaches) {
            Menu randomMenu = getRecommandationMenu(category, coach);
            coach.registerRecommendationMenu(randomMenu);
        }
    }

    private Menu getRecommandationMenu(Category category, Coach coach) {
        Menu randomMenu;
        do {
            randomMenu = category.getRandomMenu();
        } while (!coach.checkRecommended(randomMenu));
        return randomMenu;
    }

}
