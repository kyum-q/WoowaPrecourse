package oncall.constants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WeekTest {

    @ValueSource(strings = {"월","화","수","목","금","토","일"})
    @ParameterizedTest
    void 요일_판단(String s) {
        Week result = Week.getWeek(s);

        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"월, 화","화, 수","수, 목","목, 금","금, 토","토, 일","일, 월"})
    void 다음_요일_확인(String s1, String s2) {
        Week current = Week.getWeek(s1);
        Week next = current.nextWeek();

        assertThat(next.toString()).isEqualTo(s2);
    }
}