package menu.constants;

public enum RequestMessage {
    REQUEST_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    REQUEST_COACH_CANT_EAT_LIST("(이)가 못 먹는 메뉴를 입력해 주세요.");
    private String message;

    RequestMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}