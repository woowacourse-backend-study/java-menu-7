package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryFactory {

    private final List<String> menus;

    public CategoryFactory(final List<String> menus) {
        this.menus = menus;
    }

    public List<Category> createCategory() {
        List<Category> categories = new ArrayList<>();

        for (String line : menus) {
            String[] result = line.split(": ");
            String categoryName = result[0];

            List<String> menus = Arrays.asList(result[1].split(", "));

            categories.add(new Category(categoryName, menus));
        }

        return categories;
    }
}
