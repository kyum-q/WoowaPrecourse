package christmas.model;

import christmas.constant.menu.*;

public class Menu {
    private final String menuName;
    private final int size;

    private MenuKind kind;

    public Menu(String menuName, int size) {
        setMenuKind(menuName);

        if(kind == null)
            throw new IllegalArgumentException();

        this.menuName = menuName;
        this.size = size;
    }

    private void setMenuKind(String menuName) {
        if(AppetizerMenu.contains(menuName)) {
            kind = MenuKind.APPETIZER;
        }
        if(MainMenu.contains(menuName)) {
            kind = MenuKind.MAIN;
        }
        if(DessertMenu.contains(menuName)) {
            kind = MenuKind.DESSERT;
        }
        if(DrinkMenu.contains(menuName)) {
            kind = MenuKind.DRINK;
        }
    }

    public int getSize() {
        return size;
    }

    public MenuKind getKind() {
        return kind;
    }
}
