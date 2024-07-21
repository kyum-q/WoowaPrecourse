package oncall.constants;

public enum RequestMessage {
    REQUEST_MONTH_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    REQUEST_WEEKDAY_SEQUENCE("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    REQUEST_WEEKEND_SEQUENCE("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

    private String message;
    RequestMessage(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
