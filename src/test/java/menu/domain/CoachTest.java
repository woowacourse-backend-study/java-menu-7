package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CoachTest {

    @Test
    void 코치_생성() {
        Coach coach = new Coach(new Name("pobi"), List.of("스시"));

        assertThat(coach).isEqualTo(new Coach(new Name("pobi"), List.of("스시")));
    }

    @Test
    void 코치별_못_먹는_메뉴가_없을_수_있다() {
        Coach coach = new Coach(new Name("pobi"), List.of());

        assertThat(coach).isEqualTo(new Coach(new Name("pobi"), List.of()));
    }
}
