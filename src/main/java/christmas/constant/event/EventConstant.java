package christmas.constant.event;

import christmas.constant.menu.DrinkMenu;

public enum EventConstant {
    D_DAY_DISCOUNT_INIT_VALUE(1000),
    D_DAY_INCREASE_VALUE(100),
    WEEK_DISCOUNT_VALUE(2023),
    SPECIAL_DISCOUNT_VALUE(1000),
    GIFT_DISCOUNT_VALUE(DrinkMenu.CHAMPAGNE.price()),
    BADGE_LEVEL_1_VALUE(5000),
    BADGE_LEVEL_2_VALUE(10000),
    BADGE_LEVEL_3_VALUE(20000),
    EVENT_YEAR(2023),
    EVENT_MONTH(12);

    private final int value;

    EventConstant(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
