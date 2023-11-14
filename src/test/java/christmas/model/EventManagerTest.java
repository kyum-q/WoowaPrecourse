package christmas.model;

import christmas.model.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EventManagerTest {

    OrderCalculate calculate;
    EventManager eventManager;
    int date;
    List<Menu> menus;
    @BeforeEach
    void setUp() {
        calculate = new OrderCalculate();
        eventManager = new EventManager();

        date = 3;

        menus = new ArrayList<>();
        menus.add(new Menu("티본스테이크", 1));
        menus.add(new Menu("바비큐립", 1));
        menus.add(new Menu("초코케이크", 2));
        menus.add(new Menu("제로콜라", 1));
    }

    @Test
    void 메뉴와_날짜에_따른_이벤트_생성_테스트() {
        eventManager.settingEvent(date, menus, calculate.getBeforeDiscountTotalPrice(menus));

        List<Event> events = eventManager.getEvents();
        String result = "";
        for (Event event : events) {
            result += event.getEventName() + ": " + event.getDiscountPrice() + "\n";
        }

        assertThat(result).isEqualTo("크리스마스 디데이 할인: -1200\n" +
                "평일 할인: -4046\n" +
                "특별 할인: -1000\n" +
                "증정 이벤트: -25000\n"
        );
    }

    @Test
    void 메뉴와_날짜에_따른_배찌_테스트() {
        eventManager.settingEvent(date, menus, calculate.getBeforeDiscountTotalPrice(menus));
        eventManager.setBadgeEvent(calculate.getBenefitTotalPrice(eventManager.getEvents()));
        String result = eventManager.getBadge().getBadgeName();

        assertThat(result).isEqualTo("산타");
    }
}