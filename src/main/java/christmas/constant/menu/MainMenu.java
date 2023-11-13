package christmas.constant.menu;

public enum MainMenu implements MenuInterface {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String name;
    private final int price;

    MainMenu(String name, int price) {
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

    public static boolean contains(String testValue) {
        for (MainMenu menu : MainMenu.values()) {
            if (menu.menuName().equals(testValue)) {
                return true;
            }
        }
        return false;
    }
}
