package christmas.constant;

public enum DrinkMenu implements MenuConstant {
    ZERO_COLA("제로콜라",3000),
    RED_WINE("레드와인",60000),
    CHAMPAGNE("샴페인",25000);

    private final String name;
    private final int price;

    DrinkMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String menuName() {
        return name;
    }

    @Override
    public int price() {
        return price;
    }
}
