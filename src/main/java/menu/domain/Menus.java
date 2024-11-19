package menu.domain;

import static menu.util.enums.Delimiter.COMMA;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import menu.domain.vo.Menu;

public class Menus {

    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus from(String input) {
        List<Menu> menus = Arrays.stream(splitInput(input))
                .map(Menu::from)
                .toList();
        return new Menus(menus);
    }

    private static String[] splitInput(String input) {
        return input.split(COMMA.getDelimiter(), -1);
    }

    public Menu getRandomMenu() {
        List<String> list = menus.stream().map(menu -> menu.getMenuName()).toList();
        String s = Randoms.shuffle(list).get(0);
        return Menu.from(s);
    }

    public boolean isExists(Menu targetMenu) {
        return menus.stream()
                .anyMatch(menu -> menu.equals(targetMenu));
    }

    @Override
    public String toString() {
        return "Menus{" +
                "menus=" + menus +
                '}';
    }
}
