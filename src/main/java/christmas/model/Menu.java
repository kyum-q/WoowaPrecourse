package christmas.model;

import christmas.constant.menu.*;

public class Menu {
    private final String menuName;
    private final int size;
    private MenuKind kind;
    private int price;

    public Menu(String menuName, int size) {
        if(!checkMenuKind(menuName))
            throw new IllegalArgumentException();

        this.menuName = menuName;
        this.size = size;
    }

    private boolean checkMenuKind(String menuName) {
        if (setPriceAndKind(AppetizerMenu.getContainPrice(menuName), MenuKind.APPETIZER))
            return true;
        if (setPriceAndKind(MainMenu.getContainPrice(menuName), MenuKind.MAIN))
            return true;
        if (setPriceAndKind(DessertMenu.getContainPrice(menuName), MenuKind.DESSERT))
            return true;
        if (setPriceAndKind(DrinkMenu.getContainPrice(menuName), MenuKind.DRINK))
            return true;

        return false;
    }

    private boolean setPriceAndKind(int price, MenuKind kind) {
        if(price != 0) {
            this.price = price;
            this.kind = kind;
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public MenuKind getKind() {
        return kind;
    }

    public int getPrice() {
        return price * size;
    }

    @Override
    public String toString() {
        return menuName + " "  + size + "개";
    }
}
