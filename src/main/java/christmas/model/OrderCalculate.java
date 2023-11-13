package christmas.model;

import christmas.constant.event.EventConstant;
import christmas.model.event.Event;

import java.util.List;

public class OrderCalculate {
    public int getBeforeDiscountTotalPrice(List<Menu> menus) {
        return menus.stream().mapToInt(Menu::getPrice).sum();
    }

    public int getBenefitTotalPrice(List<Event> events) {
        return events.stream().mapToInt(Event::getDiscountPrice).sum();
    }

    public int getAfterDiscountTotalPrice(boolean isGift, int beforeDiscountTotalPrice, int benefitPrice) {
        if(isGift) {
            return beforeDiscountTotalPrice + benefitPrice + EventConstant.GIFT_DISCOUNT_VALUE.value();
        }
        return beforeDiscountTotalPrice + benefitPrice;
    }

}
