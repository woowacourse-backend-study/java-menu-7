package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @Test
    void Name_생성() {
        Name name = new Name("pobi");

        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "abcde"})
    void 코치_이름은_null_이나_1자_이하는_입력할_수_없다(String text) {
        assertThatThrownBy(() -> new Name(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치 이름은 2글자 이상 4글자 이하여야 합니다.");
    }
}
