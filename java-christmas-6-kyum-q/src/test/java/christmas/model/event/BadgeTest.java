package christmas.model.event;

import christmas.model.event.discount.ChristmasDDay;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @Test
    void 배지_이벤트_없음_테스트() {
        Badge badge = new Badge(4999);

        String name = badge.getBadgeName();
        assertThat(name).isEqualTo("없음");
    }

    @ValueSource(strings = {"5000", "9999"})
    @ParameterizedTest
    void 배지_이벤트_별_테스트(int value) {
        Badge badge = new Badge(value);
        String name = badge.getBadgeName();
        assertThat(name).isEqualTo("별");
    }

    @ValueSource(strings = {"10000", "19999"})
    @ParameterizedTest
    void 배지_이벤트_트리_테스트(int value) {
        Badge badge = new Badge(value);
        String name = badge.getBadgeName();
        assertThat(name).isEqualTo("트리");
    }

    @Test
    void 배지_이벤트_산타_테스트() {
        Badge badge = new Badge(20000);
        String name = badge.getBadgeName();
        assertThat(name).isEqualTo("산타");
    }
}