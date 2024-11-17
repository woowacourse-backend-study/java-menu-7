package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {

    private final String name;
    private final List<String> hateFoods;
    private final List<String> pickedMenus;

    public Coach(final String name, final List<String> hateFoods) {
        this.name = name;
        this.hateFoods = hateFoods;
        this.pickedMenus = new ArrayList<>();
    }

    public boolean canAddMenu(String menuName) {
        return !isDuplicateMenu(menuName) && !isHateFood(menuName);
    }

    private boolean isDuplicateMenu(String menuName) {
        return pickedMenus.stream().anyMatch(category -> category.equals(menuName));
    }

    private boolean isHateFood(String menuName) {
        return hateFoods.contains(menuName);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Coach coach)) {
            return false;
        }
        return Objects.equals(name, coach.name) && Objects.equals(hateFoods, coach.hateFoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hateFoods);
    }

    @Override
    public String toString() {
        String str = "";
        str += "[ " + name + "| ";
        str += String.join(" | ", pickedMenus);
        str += " ]";
        return str;
    }
}
