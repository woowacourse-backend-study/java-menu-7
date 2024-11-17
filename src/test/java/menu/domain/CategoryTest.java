package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.enums.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CategoryTest {

    @ParameterizedTest
    @CsvSource(value = {"1:일식", "2:한식", "3:중식", "4:아시안", "5:양식"}, delimiter = ':')
    void 번호에_알맞은_카테고리_이름(int number, String categoryName) {
        assertThat(Category.findNameByNumber(number)).isEqualTo(categoryName);
    }

    @Test
    void 존재하지_않는_메뉴_예외() {
        String menu = "김치찜";

        assertThatThrownBy(() -> Category.isExistMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_EXISTS_MENU.valueOf());
    }

    @Test
    void 카테고리_이름에_맞는_메뉴_가져오기() {
        String categoryName = "일식";

        assertThat(Category.findMenusByCategory(categoryName)).containsExactly("규동", "우동", "미소시루", "스시",
                "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    }

    @Test
    void 메뉴_추천() {
        assertThat(Category.recommendMenu("일식", "가츠동")).isEqualTo("가츠동");
        assertThat(Category.recommendMenu("일식", "김치찌개")).isNull();
    }
}
