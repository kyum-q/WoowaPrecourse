package christmas.model;

import christmas.constant.event.EventConstant;
import christmas.constant.menu.DrinkMenu;
import christmas.constant.menu.MenuKind;
import christmas.model.event.Badge;
import christmas.model.event.Event;
import christmas.model.event.discount.ChristmasDDay;
import christmas.model.event.discount.Gift;
import christmas.model.event.discount.SpecialDay;
import christmas.model.event.discount.Week;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventManager {
    private final List<Event> events;
    private Badge badge;
    private boolean isGiftEvent = false;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void settingEvent(int date, List<Menu> menus, int beforeDiscountTotalPrice) {
        checkChristmasDDayEvent(date);
        checkWeekEvent(date, menus);
        checkSpecialDayEvent(date);
        checkGiftEvent(beforeDiscountTotalPrice);
    }

    public void setBadgeEvent(int benefit) {
        badge = new Badge(benefit);
    }

    private void checkChristmasDDayEvent(int date) {
        if(date <= EventConstant.D_DAY_EVENT_LAST_DAY.value()) {
            events.add(new ChristmasDDay(date));
        }
    }

    private void checkWeekEvent(int date, List<Menu> menus) {
        if(menus.stream().allMatch(this::checkWeekEventKindNotContain))
            return;
        events.add(new Week(date, menus));
    }

    private boolean checkWeekEventKindNotContain(Menu menu) {
        return menu.getKind() != MenuKind.DESSERT && menu.getKind() != MenuKind.MAIN;
    }

    private void checkSpecialDayEvent(int date) {
        if(getWeek(date) == 1 || date == EventConstant.SPECIAL_EVENT_SUNDAY_OTHER_DAY.value()) {
            events.add(new SpecialDay());
        }
    }

    private void checkGiftEvent(int price) {
        if(price >= EventConstant.GIFT_CONDITION_PRICE.value()) {
            events.add(new Gift());
            isGiftEvent = true;
        }
    }

    public String containGift() {
       if(isGiftEvent) return DrinkMenu.CHAMPAGNE.menuName() + " 1개";
       return "없음";
    }



    public static int getWeek(int date) {
        Calendar cal = Calendar.getInstance();
        int year = EventConstant.EVENT_YEAR.value();
        int month = EventConstant.EVENT_MONTH.value()-1;
        cal.set(year, month, date);

        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public List<Event> getEvents() {
        return events;
    }

    public Badge getBadge() {
        return badge;
    }

    public boolean isGiftEvent() {
        return isGiftEvent;
    }
}
