package christmas.constant;

import christmas.constant.event.EventConstant;

public enum PrintMessage {
    TOTAL_MENU("주문 메뉴"),
    BEFORE_DISCOUNT_TOTAL_PRICE("할인 전 총주문 금액"),
    GIFT_MENU("증정 메뉴"),
    BENEFIT("혜택 내역"),
    TOTAL_BENEFIT("총혜택 금액"),
    AFTER_DISCOUNT_TOTAL_PRICE("할인 후 예상 결제 금액"),
    EVENT_BADGE(EventConstant.EVENT_MONTH.value() + "월 이벤트 배지"),

    ORDER_LESS_MIN_PRICE("총 주문 금액이 " + EventConstant.EVENT_MIN_PRICE.value() +"원 이상부터 이벤트가 적용됩니다.");;

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "<" + message + ">";
    }

    @Override
    public String toString() {
        return message;
    }
}