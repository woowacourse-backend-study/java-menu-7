package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CannotEatsFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"스시:가츠동", ",스시,가츠동", "스시,가츠동,"})
    void 못_먹는_음식은_콤마로_구분해야_한다(String text) {
        assertThatThrownBy(() -> CannotEatsFactory.createCannotEats(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 못 먹는 음식은 콤마로 구분해야 합니다.");
    }

    @Test
    void 못_먹는_음식이_없다면_빈_칸으로_입력한다() {
        assertThat(CannotEatsFactory.createCannotEats("")).isEqualTo(new ArrayList<>());
    }
}
