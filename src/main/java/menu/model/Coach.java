package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> dontEatMenu;
    private List<String> weekMenus;
    public Coach(String name, List<String> dontEatMenu) {
        this.name = name;
        this.dontEatMenu = dontEatMenu;
        weekMenus = new ArrayList<>();
    }

    public boolean setMenu(String menu) {
        if(weekMenus.contains(menu))
            return false;

        weekMenus.add(menu);
        return true;
    }

    @Override
    public String toString() {
        String result =  "[ " + name + " | ";
        for (int i = 0; i < weekMenus.size() - 1; i++) {
            result += weekMenus.get(i) + " | ";
        }
        return result + weekMenus.get(weekMenus.size()-1) + " ]\n";
    }
}
