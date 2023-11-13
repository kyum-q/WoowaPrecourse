package christmas.constant.menu;

public enum DrinkMenu implements MenuInterface {
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

    public static int getContainPrice(String testValue) {
        for (DrinkMenu menu : DrinkMenu.values()) {
            if (menu.menuName().equals(testValue)) {
                return menu.price();
            }
        }
        return 0;
    }
}
