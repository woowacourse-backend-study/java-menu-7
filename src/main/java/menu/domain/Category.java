package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPANESE(1, Menus.from("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼")),
    KOREAN(2, Menus.from("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음")),
    CHINESE(3, Menus.from("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채")),
    ASIAN(4, Menus.from("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜")),
    WESTERN(5, Menus.from("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"));

    private final int number;
    private final Menus menus;

    Category(int number, Menus menus) {
        this.number = number;
        this.menus = menus;
    }

    public static boolean isExistsMenu(Menu menu) {
        Category[] values = Category.values();
        List<Menus> list = Arrays.stream(values).map(Category::getMenus).toList();
        return list.stream().anyMatch(menus -> menus.isExists(menu));
    }

    public int getNumber() {
        return number;
    }

    public Menus getMenus() {
        return menus;
    }
}
