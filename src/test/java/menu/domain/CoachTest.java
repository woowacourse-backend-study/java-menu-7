package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CoachTest {

    @Test
    void 코치_생성() {
        Coach coach = new Coach(new Name("pobi"));

        assertThat(coach).isEqualTo(new Coach(new Name("pobi")));
    }
}
