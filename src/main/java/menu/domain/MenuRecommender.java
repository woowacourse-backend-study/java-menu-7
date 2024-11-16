package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuRecommender {

    public MenuOption choiceCategory(Coaches coaches) {
        String category = MenuOption.getCategoryFromNumber(Randoms.pickNumberInRange(1, 5));
        coaches.addCategory(category);
        return MenuOption.fromCategory(category);
    }

    public void choiceMenu(Coach coach, MenuOption category) {
        String menu;
        do {
            menu = Randoms.shuffle(MenuOption.getAllMenus()).get(0);
        } while (coach.cannotAddMenu(menu) && category.isContainsInCategory(menu));

        coach.addMenu(menu);
    }
}
