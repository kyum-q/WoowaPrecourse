package christmas.model;

import christmas.constant.menu.*;

public class Menu {
    private final int size;
    private MenuConstant menuConstant;

    public Menu(String menuName, int size) {
        if(!checkMenuKind(menuName))
            throw new IllegalArgumentException();

        this.size = size;
    }

    private boolean checkMenuKind(String menuName) {
        MenuConstant menuConstant = MenuConstant.getMenuInfo(menuName);
        this.menuConstant = menuConstant;
        return menuConstant != null;
    }

    public int getSize() {
        return size;
    }

    public boolean checkKind(MenuKind kind) {
        return kind == menuConstant.getMenuKind();
    }

    public int getPrice() {
        return menuConstant.price() * size;
    }

    @Override
    public String toString() {
        return menuConstant.menuName() + " "  + size + "개";
    }
}
