package oncall.constants;

public enum MonthDay {
    Jan(31),
    Feb(28),
    Mar(31),
    Apr(30),
    May(31),
    Jun(30),
    Jul(31),
    Aug(31),
    Sep(30),
    Oct(31),
    Nov(30),
    Dec(31);

    private int num;
    MonthDay(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
