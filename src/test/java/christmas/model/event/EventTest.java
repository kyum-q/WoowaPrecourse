package christmas.model.event;
import christmas.model.Menu;
import christmas.model.event.discount.ChristmasDDay;
import christmas.model.event.discount.Gift;
import christmas.model.event.discount.SpecialDay;
import christmas.model.event.discount.Week;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EventTest {
    Event event;
    int christmasDate;
    List<Menu> menus;
    @BeforeEach
    void setUp() {
        menus = new ArrayList<>();
        menus.add(new Menu("티본스테이크", 1));
        menus.add(new Menu("바비큐립", 1));
        menus.add(new Menu("초코케이크", 2));
        menus.add(new Menu("제로콜라", 1));
        christmasDate = 25;
    }

    @Test
    void 크리스마스_디데이_할인_테스트() {
        event = new ChristmasDDay(christmasDate);
        int price = event.getDiscountPrice();
        assertThat(price).isEqualTo(-3400);

        String name = event.getEventName();
        assertThat(name).isEqualTo("크리스마스 디데이 할인");
    }

    @Test
    void 평일_할인_테스트() {
        event = new Week(christmasDate, menus);
        int price = event.getDiscountPrice();
        assertThat(price).isEqualTo(-4046);

        String name = event.getEventName();
        assertThat(name).isEqualTo("평일 할인");
    }

    @Test
    void 주말_할인_테스트() {
        event = new Week(2, menus);
        int price = event.getDiscountPrice();
        assertThat(price).isEqualTo(-4046);

        String name = event.getEventName();
        assertThat(name).isEqualTo("주말 할인");
    }
    @Test
    void 특별_할인_테스트() {
        event = new SpecialDay();
        int price = event.getDiscountPrice();
        assertThat(price).isEqualTo(-1000);

        String name = event.getEventName();
        assertThat(name).isEqualTo("특별 할인");
    }

    @Test
    void 증정_이벤트_테스트() {
        event = new Gift();
        int price = event.getDiscountPrice();
        assertThat(price).isEqualTo(-25000);

        String name = event.getEventName();
        assertThat(name).isEqualTo("증정 이벤트");
    }
}