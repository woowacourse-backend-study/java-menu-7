package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendationCategories {

    private final List<Category> categories;

    private RecommendationCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static RecommendationCategories from() {
        List<Category> categories = generateRecommendationCategories();
        return new RecommendationCategories(categories);
    }

    private static List<Category> generateRecommendationCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < 5) {
            Category randomCategory = Category.getRandomCategory();
            if (countCategories(categories, randomCategory) < 2) {
                categories.add(randomCategory);
            }
        }
        return categories;
    }

    private static long countCategories(List<Category> categories, Category randomCategory) {
        return categories.stream()
                .filter(category -> category.equals(randomCategory))
                .count();
    }

    @Override
    public String toString() {
        return "RecommendationCategories{" +
                "categories=" + categories +
                '}';
    }
}
