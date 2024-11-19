package menu.domain.vo;

import java.util.Objects;

public class Menu {

    private final String menuName;

    private Menu(String menu) {
        this.menuName = menu;
    }

    public static Menu from(String input) {
        String stripped = input.strip();
        return new Menu(stripped);
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Menu menu)) {
            return false;
        }
        return Objects.equals(menuName, menu.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menuName);
    }

    @Override
    public String toString() {
        return  menuName;
    }
}
