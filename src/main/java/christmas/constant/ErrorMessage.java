package christmas.constant;

import christmas.constant.event.EventConstant;

public enum ErrorMessage {
    ERROR_DATE("유효하지 않은 날짜입니다."),
    ERROR_ORDER("유효하지 않은 주문입니다."),
    ERROR_OVER_MAX_SIZE("메뉴는 한 번에 최대 " + EventConstant.EVENT_MAX_ORDER.value() + "개까지만 주문할 수 있습니다."),
    ERROR_OVER_ONLY_DRINK("음료만 주문 시, 주문할 수 없습니다."),
    ERROR_ORDER_LESS_MIN_PRICE("총 주문 금액이 10,000원 이상부터 이벤트가 적용됩니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message + " 다시 입력해 주세요.";
    }
}
