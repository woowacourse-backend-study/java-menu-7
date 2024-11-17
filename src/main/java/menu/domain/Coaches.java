package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coaches {

    private static final int MAXIMUM_CATEGORY_NUMBER = 2;

    private final List<Coach> coachGroup;
    private final List<String> pickedCategories;

    public Coaches(final List<Coach> coachGroup) {
        this.coachGroup = coachGroup;
        this.pickedCategories = new ArrayList<>();
    }

    public boolean canAddCategory(String categoryName) {
        int count = (int) pickedCategories.stream()
                .filter(category -> category.equals(categoryName))
                .count();

        return count < MAXIMUM_CATEGORY_NUMBER;
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
}
