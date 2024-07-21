package christmas.constant.menu;

public enum MenuConstant {
    MUSHROOM_SOUP("양송이수프", 6000, MenuKind.APPETIZER),
    TAPAS("타파스", 5500, MenuKind.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuKind.APPETIZER),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuKind.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuKind.DESSERT),
    ZERO_COLA("제로콜라",3000, MenuKind.DRINK),
    RED_WINE("레드와인",60000, MenuKind.DRINK),
    CHAMPAGNE("샴페인",25000, MenuKind.DRINK),
    T_BONE_STEAK("티본스테이크", 55000, MenuKind.MAIN),
    BBQ_RIBS("바비큐립", 54000, MenuKind.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuKind.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuKind.MAIN);


    private final String name;
    private final int price;
    private final MenuKind menuKind;

    MenuConstant(String name, int price, MenuKind menuKind) {
        this.name = name;
        this.price = price;
        this.menuKind = menuKind;
    }

    public String menuName() {
        return name;
    }

    public int price() {
        return price;
    }

    public MenuKind getMenuKind() {
        return menuKind;
    }

    public static MenuConstant getMenuInfo(String testValue) {
        for (MenuConstant menu : MenuConstant.values()) {
            if (menu.menuName().equals(testValue)) {
                return menu;
            }
        }
        return null;
    }
}
