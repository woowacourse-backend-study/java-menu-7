package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RecommendMachineTest {

    private static final Coach POBI = new Coach("포비", List.of("스시"));

    @ParameterizedTest
    @CsvSource(value = {"1:일식", "2:한식", "3:중식", "4:아시안", "5:양식"}, delimiter = ':')
    void 카테고리_추천(int number, String categoryName) {
        Coaches coaches = new Coaches(List.of(POBI));

        assertThat(RecommendMachine.MACHINE.choiceCategory(coaches, number)).isEqualTo(categoryName);
    }
}
