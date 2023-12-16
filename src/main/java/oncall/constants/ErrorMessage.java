package oncall.constants;

public enum ErrorMessage {
    ERROR_MESSAGE("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    private String message;
    ErrorMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
