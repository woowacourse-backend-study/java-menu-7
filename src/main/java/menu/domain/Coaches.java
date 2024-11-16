package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coaches {

    private final List<Coach> coachGroup;
    private List<String> choicesCategories;

    public Coaches(final List<Coach> coachGroup) {
        this.coachGroup = coachGroup;
        this.choicesCategories = new ArrayList<>();
    }

    public List<Coach> getCoachGroup() {
        return coachGroup;
    }

    public void addCategory(String category) {
        choicesCategories.add(category);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Coaches coaches)) {
            return false;
        }
        return Objects.equals(coachGroup, coaches.coachGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachGroup);
    }

    @Override
    public String toString() {
        String result = "";
        result += "[ 카테고리 | ";
        result += String.join(" | ", choicesCategories);
        result += "]\n";
        result += coachGroup.stream()
                .map(Coach::toString)
                .collect(Collectors.joining("\n"));

        return result;
    }

    public boolean canAddCategory(String category) {
        int count = (int) choicesCategories.stream().filter(menu -> menu.equals(category)).count();
        return count <= 2;
    }
}
