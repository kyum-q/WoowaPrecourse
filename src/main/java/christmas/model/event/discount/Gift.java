package christmas.model.event.discount;

import christmas.constant.event.EventConstant;
import christmas.constant.event.EventName;
import christmas.model.event.Event;

public class Gift extends Event {
    public Gift() {
        discountPrice = EventConstant.GIFT_DISCOUNT_VALUE.value();
        eventName = EventName.EVENT_GIFT;
    }
}
