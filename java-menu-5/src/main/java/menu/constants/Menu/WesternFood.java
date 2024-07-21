package menu.constants.Menu;

public enum WesternFood {
    lasagna("라자냐"),
    gratin("그라탱"),
    gnocchi("뇨끼"),
    kishu("끼슈"),
    french_toast("프렌치 토스트"),
    baguette("바게트"),
    spaghetti("스파게티"),
    pizza("피자"),
    panini("파니니");


    private String menu;
    WesternFood(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return menu;
    }

    public static WesternFood getMenuInfo(String testValue) {
        for (WesternFood menu : WesternFood.values()) {
            if (menu.toString().equals(testValue)) {
                return menu;
            }
        }
        return null;
    }
}
