package oncall.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SequenceValidatorTest {

    SequenceValidator validator;

    @BeforeEach
    void setUp() {
        validator = new SequenceValidator();
    }

    @ValueSource(strings = {"1,2,3,4","1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36"})
    @ParameterizedTest
    void 근무사원_5명_미만_35명_초과(String s) {
        boolean result1 = validator.validWeekly(s);
        boolean result2 = validator.validWeekend(s);
        assertThat(result1 && result2).isEqualTo(false);
    }

    @ValueSource(strings = {",2,3,4,5","1,2,3,4,555555"})
    @ParameterizedTest
    void 닉네임_1자_미만_5자_초과(String s) {
        boolean result1 = validator.validWeekly(s);
        boolean result2 = validator.validWeekend(s);
        assertThat(result1 && result2).isEqualTo(false);
    }

    @ValueSource(strings = {"1,2,3,4,1","1,2,2,3,4"})
    @ParameterizedTest
    void 닉네임_중복(String s) {
        boolean result1 = validator.validWeekly(s);
        boolean result2 = validator.validWeekend(s);
        assertThat(result1 && result2).isEqualTo(false);
    }

    @Test
    void 평일_근무_사원에_없는_닉네임이_휴일_근무_사원에_존재() {
        boolean result1 = validator.validWeekly("1,2,3,4,5,6");
        boolean result2 = validator.validWeekend("0,1,2,3,4,5,6");
        assertThat(result1 && result2).isEqualTo(false);
    }
}