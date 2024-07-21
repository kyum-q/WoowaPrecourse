package oncall.constants;

public enum NicNameConstants {
    STAFF_MIN_COUNT(5),
    STAFF_MAX_COUNT(35),
    MIN_NAME_LEN(1),
    MAX_NAME_LEN(5);

    private int num;
    NicNameConstants(int i) {
        num = i;
    }

    public int getNum() {
        return num;
    }
}
