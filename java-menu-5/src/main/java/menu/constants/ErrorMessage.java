package menu.constants;

public enum ErrorMessage {
    ERROR_COACH_COUNT("코치는 최소 " + RecommendConstants.COACH_MIN_COUNT + "명, 최대 " + RecommendConstants.COACH_MAX_COUNT + "명 입력해야 합니다."),
    ERROR_COACH_NAME("코치의 이름은 최소 " + RecommendConstants.COACH_MIN_NAME_LEN + "글자, 최대 " + RecommendConstants.COACH_MAX_NAME_LEN + "글자로 입력해야 합니다."),
    ERROR_COACH_NAME_OVERLAP("코치 이름이 중복되지 않게 입력해야 합니다."),
    ERROR_DONT_EAT_COUNT("각 코치는 최소 " + RecommendConstants.DONT_EAT_MENU_MIN + "개, 최대 " + RecommendConstants.DONT_EAT_MENU_MAX + "개의 못 먹는 메뉴를 입력해야 합니다."),
    ERROR_WITHOUT_MENU("존재하지 않는 음식이 입력되었습니다.");

    private String message;
    ErrorMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return  "[ERROR] " +message;
    }
}
