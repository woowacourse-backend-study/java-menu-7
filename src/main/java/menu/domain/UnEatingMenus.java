package menu.domain;

import static menu.util.enums.ErrorMessage.INVALID_UN_EATING_MENU_SIZE;

import java.util.ArrayList;
import java.util.List;
import menu.domain.vo.Menu;

public class UnEatingMenus {

    private static final int MAX_SIZE = 2;

    private final List<Menu> unEatingMenus = new ArrayList<>();

    private UnEatingMenus() {
    }

    public static UnEatingMenus create() {
        return new UnEatingMenus();
    }

    public void addUnEatingMenu(Menu menu) {
        validate(menu);
        unEatingMenus.add(menu);
    }

    public boolean isContain(Menu menu) {
        return unEatingMenus.contains(menu);
    }

    private void validate(Menu menu) {
        validateSize();
        validateUnExistsMenu(menu);
    }

    private void validateSize() {
        if (unEatingMenus.size() >= MAX_SIZE) {
            unEatingMenus.clear();
            throw new IllegalArgumentException(INVALID_UN_EATING_MENU_SIZE.getMessage());
        }
    }

    private void validateUnExistsMenu(Menu menu) {
        if (!Category.isExistsMenu(menu)) {
            unEatingMenus.clear();
            throw new IllegalArgumentException();
        }
        ;
    }

    @Override
    public String toString() {
        return "UnEatingMenus{" +
                "unEatingMenus=" + unEatingMenus +
                '}';
    }
}
