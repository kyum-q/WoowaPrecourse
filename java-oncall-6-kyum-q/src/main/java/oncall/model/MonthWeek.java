package oncall.model;

import oncall.constants.Holiday;
import oncall.constants.MonthDay;
import oncall.constants.Week;

public class MonthWeek {
    private int month, day;
    private Week week;
    private MonthDay monthDay;
    private boolean isWeeklyHoliday = false;

    public MonthWeek(int month, Week week) {
        this.month = month;
        this.day = 1;
        this.week = week;

        monthDay = MonthDay.values()[month - 1];
    }

    public boolean next() {
        if (day >= monthDay.getNum())
            return false;
        day++;
        week = week.nextWeek();
        return true;
    }

    public boolean checkHoliday() {
        isWeeklyHoliday = false;
        if (week.equals(Week.Sat) || week.equals(Week.Sun))
            return true;
        isWeeklyHoliday = Holiday.isHoliday(month, day);
        return isWeeklyHoliday;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(month).append("월 ").append(day).append("일 ").append(week);
        if (isWeeklyHoliday) {
            result.append("(휴일)");
        }
        return result.toString();
    }
}
