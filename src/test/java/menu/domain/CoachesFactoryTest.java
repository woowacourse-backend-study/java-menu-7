package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoachesFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"포비:나나", "포비,누누,", ",포비,누누"})
    void 코치_이름은_콤마로_구분해야_한다(String text) {
        assertThatThrownBy(() -> CoachesFactory.createCoaches(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치 이름은 콤마로 구분해야 합니다.");
    }
}
