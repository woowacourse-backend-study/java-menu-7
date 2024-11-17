package menu.domain;

public enum RecommendMachine {

    MACHINE;

    public String choiceCategory(Coaches coaches, int random) {
        String categoryName;
        do {
            categoryName = Category.findNameByNumber(random);
        } while (!coaches.canAddCategory(categoryName));

        coaches.addCategory(categoryName);
        return categoryName;
    }

    public void choiceMenu(String categoryName, String menuName, Coach coach) {
        String menu;
        do {
            menu = Category.recommendMenu(categoryName, menuName);
        } while (!coach.canAddMenu(menu));

        coach.addMenu(menu);
    }
}
