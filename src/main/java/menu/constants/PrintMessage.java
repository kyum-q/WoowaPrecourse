package menu.constants;

public enum PrintMessage {
    PRINT_START_WORD("점심 메뉴 추천을 시작합니다."),
    PRINT_ENDING_WORD_START("메뉴 추천 결과입니다."),
    PRINT_ENDING_WORD_CATEGORY("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    PRINT_ENDING_WORD_LAST("추천을 완료했습니다.");

    private String message;
    PrintMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
