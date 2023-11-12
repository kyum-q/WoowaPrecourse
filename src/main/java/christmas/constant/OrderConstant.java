package christmas.constant;

public enum OrderConstant {
    MIN_DATE(1),
    MAX_DATE(31),
    MIN_ORDER(1),
    MAX_ORDER(20);

    private final int number;
    OrderConstant(int num) {
        this.number = num;
    }

    public int getNumber() {
        return number;
    }
}
