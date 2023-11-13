package christmas.model.event;

import christmas.constant.event.EventConstant;
import christmas.constant.event.EventName;

import java.util.Calendar;

public class Event {
    protected int discountPrice;
    protected EventName eventName;

    public int getDiscountPrice() {
        return discountPrice * -1;
    }

    public String getEventName() {
        return eventName.getName();
    }

    public int getWeek(int date) {
        Calendar cal = Calendar.getInstance();
        int year = EventConstant.EVENT_YEAR.value();
        int month = EventConstant.EVENT_MONTH.value()-1;
        cal.set(year, month, date);

        return cal.get(Calendar.DAY_OF_WEEK);
    }
}
