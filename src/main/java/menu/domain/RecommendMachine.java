package menu.domain;

public enum RecommendMachine {

    MACHINE;

    public String choiceCategory(Coaches coaches, int random) {
        String categoryName;
        do {
            categoryName = Category.getName(random);
        } while (coaches.canAddCategory(categoryName));

        return categoryName;
    }

    public String choiceMenu(String categoryName, Coach coach) {
        String menuName;
        do {
            menuName = Category.recommendMenu(categoryName);
        } while (coach.canAddMenu(menuName));

        return menuName;
    }
}
