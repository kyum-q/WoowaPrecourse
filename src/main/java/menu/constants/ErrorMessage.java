package menu.constants;

public enum ErrorMessage {
    ERROR_COACH_COUNT("코치는 최소 " + RecommendConstants.COACH_MIN_COUNT + "명, 최대 " + RecommendConstants.COACH_MAX_COUNT + "명 입력해야 합니다."),
    ERROR_COACH_NAME("코치의 이름은 최소 " + RecommendConstants.COACH_MIN_NAME_LEN + "글자, 최대 " + RecommendConstants.COACH_MAX_NAME_LEN + "글자로 입력해야 합니다.");

    private String message;
    ErrorMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return  "[ERROR] " +message;
    }
}
