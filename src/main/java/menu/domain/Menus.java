package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

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

    public static Menus createUnEatingMenusFrom(String input) {
        if(input.isEmpty()) {
            return null;
        }
        List<Menu> menus = Arrays.stream(splitInput(input))
                .map(Menu::from)
                .toList();
        validateUnEatingMenus(menus);
        return new Menus(menus);
    }

    private static void validateUnEatingMenus(List<Menu> menus) {
        validateUnExistsMenu(menus);
        validateUnExistsSize(menus);
    }

    private static void validateUnExistsMenu(List<Menu> menus) {
        for (Menu menu : menus) {
            if (!Category.isExistsMenu(menu)) {
                throw new IllegalArgumentException("[ERROR] 입력하신 메뉴를 전체 메뉴 목록에서 찾을 수 없습니다.");
            };
        }
    }

    private static void validateUnExistsSize(List<Menu> menus) {
        if (  menus.size() > 2 ) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개까지 입력 가능합니다.");
        }
    }

    private static String[] splitInput(String input) {
        return input.split(",", -1);
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
