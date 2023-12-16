package oncall.constants;

public enum Week {
    Mon("월"),
    Tue("화"),
    Wed("수"),
    Thu("목"),
    Fri("금"),
    Sat("토"),
    Sun("일");

    private String week;
    Week(String week) {
        this.week = week;
    }

    public static Week getWeek(String s) {
        for (Week week : Week.values()) {
            if (week.week.equals(s)) {
                return week;
            }
        }
        return null;
    }
}
