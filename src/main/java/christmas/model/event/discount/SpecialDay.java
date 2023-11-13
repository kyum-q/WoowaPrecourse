package christmas.model.event.discount;

import christmas.constant.event.EventConstant;
import christmas.constant.event.EventName;
import christmas.model.event.Event;

public class SpecialDay extends Event {
    public SpecialDay() {
        discountPrice = EventConstant.SPECIAL_DISCOUNT_VALUE.value();
        eventName = EventName.EVENT_SPECIAL_DAY;
    }
}
