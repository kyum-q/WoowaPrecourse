package oncall.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MonthWeekValidatorTest {

    MonthWeekValidator validator;
    @BeforeEach
    void setUp() {
        validator = new MonthWeekValidator();
    }

    @ValueSource(strings = {"1,2,3", "d,f,e", "", "5", "월"})
    @ParameterizedTest
    void 다른_문자_추가_입력_혹은_입력_안함(String s) {
        boolean result = validator.valid(s);
        assertThat(result).isEqualTo(false);
    }

    @ValueSource(strings = {"0,월","13,월"})
    @ParameterizedTest
    void 월_1미만_12초과(String s) {
        boolean result = validator.valid(s);
        assertThat(result).isEqualTo(false);
    }

    @ValueSource(strings = {"1,슈","1,귬"})
    @ParameterizedTest
    void 요일_잘못_입력(String s) {
        boolean result = validator.valid(s);
        assertThat(result).isEqualTo(false);
    }
}