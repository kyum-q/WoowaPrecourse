package oncall.validator;

import oncall.constants.Week;
import oncall.model.MonthWeek;

public class MonthWeekValidator {
    private String [] split;
    private int month;
    private Week week;
    public boolean valid(String s) {
        return validOtherChar(s) && validMonth() && validWeek();
    }

    private boolean validOtherChar(String s) {
        try {
            split = s.split(",", -1);
            if(split.length != 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validMonth() {
        try {
            month = Integer.parseInt(split[0]);
            if(month < 1 || month > 12)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validWeek() {
        try {
            week = Week.getWeek(split[1]);
            if(week == null)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public MonthWeek getResult() {
        return new MonthWeek(month, week);
    }
}
