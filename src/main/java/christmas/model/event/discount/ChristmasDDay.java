package christmas.model.event.discount;

import christmas.constant.event.EventConstant;
import christmas.constant.event.EventName;
import christmas.model.event.Event;

public class ChristmasDDay extends Event {
    public ChristmasDDay(int date) {
        int init = EventConstant.D_DAY_DISCOUNT_INIT_VALUE.value();
        int increase = EventConstant.D_DAY_INCREASE_VALUE.value();
        discountPrice = init + increase * (date - 1);

        eventName = EventName.EVENT_D_DAY;
    }
}
