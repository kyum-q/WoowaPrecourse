package christmas.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DateValidatorTest {

    DateValidator dateValidator;
    @BeforeEach
    void setUp() {
        dateValidator = new DateValidator();
    }

    @ValueSource(strings = {"a", "0", "32"})
    @ParameterizedTest
    void 날짜_예외_테스트(String s) {
        boolean result = dateValidator.validate(s);
        assertThat(result).isEqualTo(false);
    }
}