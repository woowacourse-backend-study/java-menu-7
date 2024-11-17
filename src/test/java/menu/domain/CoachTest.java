package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CoachTest {

    private static final Coach POBI = new Coach("포비", List.of("김치찌개"));

    @Test
    void 코치_생성() {
        assertThat(POBI).isEqualTo(new Coach("포비", List.of("김치찌개")));
    }

    @Test
    void 중복_메뉴는_추천받을_수_없다() {
        POBI.addMenu("스시");

        assertThat(POBI.canAddMenu("스시")).isFalse();
        assertThat(POBI.canAddMenu("가츠동")).isTrue();
    }

    @Test
    void 싫어하는_메뉴는_추천받을_수_없다() {
        assertThat(POBI.canAddMenu("김치찌개")).isFalse();
    }

    @Test
    void 메뉴_추천받기() {
        POBI.addMenu("스시");

        assertThat(POBI.canAddMenu("스시")).isFalse();
    }
}
