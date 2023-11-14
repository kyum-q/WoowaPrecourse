package christmas.model;

import christmas.model.event.Event;
import christmas.model.event.discount.ChristmasDDay;
import christmas.model.event.discount.Gift;
import christmas.model.event.discount.SpecialDay;
import christmas.model.event.discount.Week;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderCalculateTest {

    OrderCalculate calculate;
    int date;
    List<Menu> menus;
    List<Event> events;
    @BeforeEach
    void setUp() {
        calculate = new OrderCalculate();

        date = 3;

        menus = new ArrayList<>();
        menus.add(new Menu("티본스테이크", 1));
        menus.add(new Menu("바비큐립", 1));
        menus.add(new Menu("초코케이크", 2));
        menus.add(new Menu("제로콜라", 1));

        events = new ArrayList<>();
        events.add(new ChristmasDDay(date));
        events.add(new Week(date, menus));
        events.add(new SpecialDay());
        events.add(new Gift());
    }

    @Test
    void 할인_전_총주문_금액_테스트() {
        int result = calculate.getBeforeDiscountTotalPrice(menus);

        assertThat(result).isEqualTo(142000);
    }

    @Test
    void 총_혜택_금액_테스트() {
        int result = calculate.getBenefitTotalPrice(events);

        assertThat(result).isEqualTo(-31246);
    }

    @Test
    void getAfterDiscountTotalPrice() {
        int price = calculate.getBeforeDiscountTotalPrice(menus);
        int benefit = calculate.getBenefitTotalPrice(events);
        int result = calculate.getAfterDiscountTotalPrice(true, price, benefit);

        assertThat(result).isEqualTo(135754);
    }
}