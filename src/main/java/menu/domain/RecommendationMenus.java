package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.domain.vo.Menu;

public class RecommendationMenus {

    private final List<Menu> recommendationMenus = new ArrayList<>();

    private RecommendationMenus() {}

    public static RecommendationMenus create() {
        return new RecommendationMenus();
    }

    public void addRecommendationMenus(Menu menu) {
        recommendationMenus.add(menu);
    }

    public boolean isDuplicate(Menu menu) {
        return recommendationMenus.contains(menu);
    }

    public List<Menu> getRecommendationMenus() {
        return recommendationMenus.stream().toList();
    }

    @Override
    public String toString() {
        return "RecommendationMenus{" +
                "recommendationMenus=" + recommendationMenus +
                '}';
    }
}
