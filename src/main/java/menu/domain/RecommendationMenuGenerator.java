package menu.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RecommendationMenuGenerator {

    public LinkedHashMap<Coach, List<Menu>> recommendationMenusGenerator(Coaches coaches, UnEatingMenusMapper unEatingMenusMapper) {
        List<Category> categories = new ArrayList<>();
        LinkedHashMap<Coach, List<Menu>> recommendationMenus = new LinkedHashMap<>();


        while (categories.size() < 5) {
            Category randomCategory = Category.getRandomCategory();
            if (countCategories(categories, randomCategory) < 2) {
                categories.add(randomCategory);
                generateRandomMenu(randomCategory, coaches, recommendationMenus, unEatingMenusMapper);
            }
        }
        return recommendationMenus;
    }

    private void generateRandomMenu(Category category, Coaches coaches, LinkedHashMap<Coach, List<Menu>> recommendationMenus, UnEatingMenusMapper unEatingMenusMapper) {
        List<Coach> getCoaches = coaches.getCoaches();
        for (Coach coach : getCoaches) {
            List<Menu> currentMenus = recommendationMenus.get(coach);
            if (currentMenus == null) {
                recommendationMenus.put(coach, new ArrayList<>());
                currentMenus = recommendationMenus.get(coach);
            }
            Menu randomMenu = getRecommandationMenu(category, currentMenus,coach, unEatingMenusMapper);
            currentMenus.add(randomMenu);
            recommendationMenus.put(coach, currentMenus);
        }
    }

    private long countCategories(List<Category> categories, Category randomCategory) {
        return categories.stream()
                .filter(category -> category.equals(randomCategory))
                .count();
    }

    private Menu getRecommandationMenu(Category category , List<Menu> currentMenus, Coach coach , UnEatingMenusMapper unEatingMenusMapper) {
        Menu randomMenu;
        do {
            randomMenu = category.getRandomMenu();
            unEatingMenusMapper.isContainMenuByCoach(coach, randomMenu);
        } while (currentMenus.contains(randomMenu) || unEatingMenusMapper.isContainMenuByCoach(coach, randomMenu));
        return randomMenu;
    }
}
