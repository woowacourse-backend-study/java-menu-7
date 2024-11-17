package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CoachesTest {

    @Test
    void Coaches_생성() {
        Coaches coaches = new Coaches(List.of(new Coach("포비", List.of("스시"))));

        assertThat(coaches).isEqualTo(new Coaches(List.of(new Coach("포비", List.of("스시")))));
    }

    @Test
    void 카테고리_추천_가능_여부_판단() {
        Coaches coaches = new Coaches(List.of(new Coach("포비", List.of("스시"))));

        coaches.addCategory("일식");
        coaches.addCategory("일식");

        assertThat(coaches.canAddCategory("일식")).isFalse();
        assertThat(coaches.canAddCategory("한식")).isTrue();
    }
}
