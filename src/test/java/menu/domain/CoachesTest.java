package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CoachesTest {

    private static final Coach POBI = new Coach(new Name("pobi"));

    @Test
    void Coaches_생성() {
        Coach pobi = new Coach(new Name("pobi"));
        Coach nunu = new Coach(new Name("nunu"));

        Coaches coaches = new Coaches(List.of(pobi, nunu));

        assertThat(coaches).isEqualTo(new Coaches(List.of(pobi, nunu)));
    }

    @Test
    void 코치는_최소_2명_이상이어야_한다() {
        assertThatThrownBy(() -> new Coaches(List.of(POBI)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 최소 2명 이상 5명 이하여야 합니다.");
    }
}
