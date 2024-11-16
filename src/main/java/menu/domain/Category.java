package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Category {

    private final String name;
    private final List<String> menus;

    public Category(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public List<String> pickMenu(int number) {
        List<String> menus = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String menu = Randoms.shuffle(menus).get(0);
            menus.add(menu);
        }

        return menus;
    }
}
