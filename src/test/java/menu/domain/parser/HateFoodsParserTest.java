package menu.domain.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.enums.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HateFoodsParserTest {

    @Test
    void 싫어하는_음식은_콤마로_구분해야_한다() {
        Assertions.assertThat(HateFoodsParser.parse("김치찌개,스시")).contains("김치찌개", "스시");
        assertThat(HateFoodsParser.parse("")).hasSize(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"김치찌개:스시", ",김치찌개,스시", "김치찌개,스시,"})
    void 싫어하는_음식이_콤마로_구분되지_않으면_예외(String input) {
        assertThatThrownBy(() -> HateFoodsParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNDIVIDED_NAME_BY_COMMA.valueOf());
    }

    @Test
    void 싫어하는_음식은_2개_이하여야_한다() {
        assertThatThrownBy(() -> HateFoodsParser.parse("김치찌개,스시,가츠동"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_OF_HATE_FOODS.valueOf());
    }
}
