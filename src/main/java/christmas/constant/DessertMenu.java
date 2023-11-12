package christmas.constant;

public enum DessertMenu implements MenuConstant {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String name;
    private final int price;

    DessertMenu(String name, int price) {
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
