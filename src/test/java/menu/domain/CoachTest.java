package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.error.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"포", "빨주노초파"})
    void 코치_이름은_2글자_이상_4글자_이하여야_한다(String name) {
        assertThatThrownBy(() -> new Coach(name, List.of("스시")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COACH_NAME_LENGTH.valueOf());
    }
}
