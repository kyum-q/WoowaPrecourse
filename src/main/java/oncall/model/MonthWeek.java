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
        if (week.toString().equals("토") || week.toString().equals("일"))
            return true;
        isWeeklyHoliday = Holiday.isHoliday(month, day);
        return isWeeklyHoliday;
    }

    @Override
    public String toString() {
        if (isWeeklyHoliday)
            return month + "월 " + day + "일 " + week + "(휴일)";
        return month + "월 " + day + "일 " + week;
    }
}
