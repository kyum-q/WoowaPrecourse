package christmas.constant;

public enum ErrorMessage {
    ERROR_DATE("유효하지 않은 날짜입니다."),
    ERROR_ORDER_OTHER_DATE("유효하지 않은 주문입니다."),
    ERROR_ORDER_NOT_EXIST_MENU("없는 메뉴는 주문할 수 없습니다."),
    ERROR_OVER_MAX_SIZE("메뉴는 최대 " + OrderConstant.MAX_ORDER.getNumber() + "개까지만 주문 가능합니다."),
    ERROR_OVER_ONLY_DRINK("음료만 주문하실 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message + " 다시 입력해 주세요.";
    }
}
