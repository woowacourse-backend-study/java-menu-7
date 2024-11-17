package menu.domain.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.enums.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachNameParserTest {

    @Test
    void 코치_이름은_콤마로_구분해야_한다() {
        Assertions.assertThat(CoachNameParser.parse("포비,나나")).contains("포비", "나나");
    }

    @ParameterizedTest
    @ValueSource(strings = {"포,포비", "빨주노초파,포비"})
    void 코치_이름은_2글자_이상_4글자_이하여야_한다(String input) {
        assertThatThrownBy(() -> CoachNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COACH_NAME_LENGTH.valueOf());
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비:나나", ",포비,나나", "포비,나나,"})
    void 코치_이름이_콤마로_구분되지_않으면_예외(String input) {
        assertThatThrownBy(() -> CoachNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNDIVIDED_NAME_BY_COMMA.valueOf());
    }

    @ParameterizedTest
    @ValueSource(strings = {"포비", "포비,가가,나나,다다,라라,마마"})
    void 코치는_2명_이상_5명_이하여야_한다(String input) {
        assertThatThrownBy(() -> CoachNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_OF_COACH.valueOf());
    }
}
