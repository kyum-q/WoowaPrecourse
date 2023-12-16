package oncall.model;

import oncall.constants.Week;

public class MonthWeek {
    private int month;
    private Week week;
    public MonthWeek(int month, Week week) {
        this.month = month;
        this.week = week;
    }
}
