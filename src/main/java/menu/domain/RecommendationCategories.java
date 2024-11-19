package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendationCategories {

    private static final int REGISTRABLE_CATEGORY_COUNT = 2;

    private final List<Category> recommendationCategories = new ArrayList<>();

    private RecommendationCategories() {}

    public static RecommendationCategories create() {
        return new RecommendationCategories();
    }

    public void addRecommendationCategories(Category category) {
        recommendationCategories.add(category);
    }

    public boolean checkRegistrable(Category target) {
        return matchesCategoriesCount(target) < REGISTRABLE_CATEGORY_COUNT;
    }

    private int matchesCategoriesCount(Category target) {
        return (int) recommendationCategories.stream()
                .filter(category -> category.equals(target))
                .count();
    }

    public int getSize() {
        return recommendationCategories.size();
    }

    public List<Category> getRecommendationCategories() {
        return recommendationCategories.stream().toList();
    }

    @Override
    public String toString() {
        return "RecommendationCategories{" +
                "recommendationCategories=" + recommendationCategories +
                '}';
    }
}
