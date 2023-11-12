package christmas.constant;

public enum ErrorMessage {
    ERROR_DATE(OrderConstant.MIN_DATE.getNumber() + "-" + OrderConstant.MAX_DATE.getNumber() + " 숫자 중에 입력해주세요."),
    ERROR_ORDER_OTHER_DATE("메뉴 입력 형식을 지켜주세요. (e.g. 시저샐러드-1, 티본스테이크-1)"),
    ERROR_ORDER_NOT_EXIST_MENU("없는 메뉴는 주문할 수 없습니다."),
    ERROR_OVER_MAX_SIZE("메뉴는 최대 " + OrderConstant.MAX_ORDER.getNumber() + "개까지만 주문 가능합니다."),
    ERROR_OVER_ONLY_DRINK("음료만 주문하실 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
