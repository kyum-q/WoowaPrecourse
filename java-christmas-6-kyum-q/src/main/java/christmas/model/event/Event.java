package christmas.model.event;

import christmas.constant.event.EventConstant;
import christmas.constant.event.EventName;
import christmas.view.Output;

import java.util.Calendar;

public class Event {
    protected int discountPrice;
    protected EventName eventName;

    public int getDiscountPrice() {
        return discountPrice * -1;
    }

    @Override
    public String toString() {
        return eventName.getName() + ": " + String.format("%,d원", discountPrice * -1);
    }
}
