package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CoachesTest {

    private static final Coach POBI = new Coach(new Name("pobi"), List.of("스시"));
    private static final Coach NUNU = new Coach(new Name("nunu"), List.of("스시"));
    private static final Coach HAHA = new Coach(new Name("haha"), List.of("스시"));
    private static final Coach HOHO = new Coach(new Name("hoho"), List.of("스시"));
    private static final Coach LALA = new Coach(new Name("lala"), List.of("스시"));
    private static final Coach MIMU = new Coach(new Name("mimu"), List.of("스시"));

    @Test
    void Coaches_생성() {
        Coaches coaches = new Coaches(List.of(POBI, NUNU));

        assertThat(coaches).isEqualTo(new Coaches(List.of(POBI, NUNU)));
    }

    @Test
    void 코치는_최소_2명_이상이어야_한다() {
        assertThatThrownBy(() -> new Coaches(List.of(POBI)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 최소 2명 이상 5명 이하여야 합니다.");
    }

    @Test
    void 코치는_최대_5명_이하여야_한다() {
        assertThatThrownBy(() -> new Coaches(List.of(POBI, NUNU, HAHA, HOHO, LALA, MIMU)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 최소 2명 이상 5명 이하여야 합니다.");
    }
}
