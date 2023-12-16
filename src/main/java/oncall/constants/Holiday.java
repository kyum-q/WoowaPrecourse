package oncall.constants;

import java.time.Year;

public enum Holiday {
    New_Year(1,1),
    Samiljeol(3,1),
    Children(5,5),
    Memorial(6,6),
    Liberation(8,15),
    National_Foundation(10,3),
    Hangul(10,9),
    Christmas(12,25);

    private int month;
    private int day;
    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        for (Holiday holiday : Holiday.values()) {
            if (holiday.month == month && holiday.day == day) {
                return true;
            }
        }
        return false;
    }
}
