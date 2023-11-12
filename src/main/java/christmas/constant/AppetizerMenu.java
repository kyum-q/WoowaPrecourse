package christmas.constant;

public enum AppetizerMenu implements MenuInterface {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String name;
    private final int price;

    AppetizerMenu(String name, int price) {
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
        for (AppetizerMenu menu : AppetizerMenu.values()) {
            if (menu.menuName().equals(testValue)) {
                return true;
            }
        }
        return false;
    }
}
