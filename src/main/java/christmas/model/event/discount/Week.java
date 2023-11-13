package christmas.model.event.discount;

import christmas.constant.event.EventConstant;
import christmas.constant.event.EventName;
import christmas.constant.menu.MenuKind;
import christmas.model.EventManager;
import christmas.model.Menu;
import christmas.model.event.Event;

import java.util.List;


public class Week extends Event {
    private final boolean isWeekend;
    public Week(int date, List<Menu> menus) {
        isWeekend = checkWeekends(date);
        discountPrice = getDiscountPrice(menus);
    }

    private boolean checkWeekends(int date) {
        int week = EventManager.getWeek(date);

        if(week==6 || week==7) {
            eventName = EventName.EVENT_WEEKEND;
            return true;
        }
        eventName = EventName.EVENT_WEEKDAY;
        return false;
    }

    private int getDiscountPrice(List<Menu> menus) {
        if(isWeekend) {
            int mainOrderSize = menus.stream().filter(menu -> menu.getKind() == MenuKind.MAIN)
                    .mapToInt(Menu::getSize).sum();
            return mainOrderSize * EventConstant.WEEK_DISCOUNT_VALUE.value();
        }
        int mainOrderSize = menus.stream().filter(menu -> menu.getKind() == MenuKind.DESSERT)
                .mapToInt(Menu::getSize).sum();
        return mainOrderSize * EventConstant.WEEK_DISCOUNT_VALUE.value();
    }
}
