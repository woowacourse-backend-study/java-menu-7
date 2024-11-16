package menu.domain;

import java.util.Map;

public class UnEatingMenusMapper {
    private final Map<Coach, Menus> unEatingMenus;

    private UnEatingMenusMapper(Map<Coach, Menus> unEatingMenus) {
        this.unEatingMenus = unEatingMenus;
    }

    public static UnEatingMenusMapper from(Map<Coach, Menus> unEatingMenus) {
        return new UnEatingMenusMapper(unEatingMenus);
    }

    public boolean isContainMenuByCoach(Coach coach, Menu menu) {
        Menus menus = unEatingMenus.get(coach);
        if (menus == null) {
            return false;
        }
        return menus.isExists(menu);
    }
}
