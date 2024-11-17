package menu.domain;

import static menu.enums.RecommendResultSign.CATEGORY;
import static menu.enums.RecommendResultSign.CLOSE_PARENTHESES;
import static menu.enums.RecommendResultSign.DAY_SEPARATOR;
import static menu.enums.RecommendResultSign.LINE_CHANGE;
import static menu.enums.RecommendResultSign.OPEN_PARENTHESES;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public void addCategory(String categoryName) {
        pickedCategories.add(categoryName);
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
        String str = OPEN_PARENTHESES.valueOf() + CATEGORY.valueOf() + DAY_SEPARATOR.valueOf();
        str += String.join(DAY_SEPARATOR.valueOf(), pickedCategories);
        str += CLOSE_PARENTHESES.valueOf() + LINE_CHANGE.valueOf();
        str += coachGroup.stream().map(Coach::toString).collect(Collectors.joining(LINE_CHANGE.valueOf()));
        return str;
    }
}
