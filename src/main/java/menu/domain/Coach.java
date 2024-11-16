package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {

    private final Name name;
    private final List<String> cannotEats;
    private List<String> choicedMenu;

    public Coach(String name, List<String> cannotEats) {
        this(new Name(name), cannotEats);
    }

    public Coach(final Name name, final List<String> cannotEats) {
        this.name = name;
        this.cannotEats = cannotEats;
        this.choicedMenu = new ArrayList<>();
    }

    public boolean cannotAddMenu(String menu) {
        return cannotEats.stream().anyMatch(food -> food.equals(menu)) && choicedMenu.contains(menu);
    }

    public void addMenu(String menu) {
        choicedMenu.add(menu);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Coach coach)) {
            return false;
        }
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        String str = "[ ";
        str += name.toString() + " | ";
        str += String.join(" | ", choicedMenu);
        str += "]";
        return str;
    }
}
