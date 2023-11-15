package christmas.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderMenuValidatorTest {

    OrderMenuValidator menuValidator;

    @BeforeEach
    void setUp() {
        menuValidator = new OrderMenuValidator();
    }

    @ValueSource(strings = {"제로콜라-a", "볶음밥-2", "시저샐러드-1 ,시저샐러드-2", "시저샐러드-0", "시저샐러드-1, 샴페인-0",
            "시저샐러드-1, 티본스테이크-20", "제로콜라-1", "제로콜라-1, 샴페인-3"})
    @ParameterizedTest
    void 주문_예외_테스트(String s) {
        boolean result = menuValidator.validate(s);
        assertThat(result).isEqualTo(false);
    }

}