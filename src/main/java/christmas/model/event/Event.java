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

}
