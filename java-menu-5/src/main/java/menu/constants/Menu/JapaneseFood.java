package menu.constants.Menu;

public enum JapaneseFood {
    Gyudon("규동"),
    Udon("우동"),
    Miso_Siru("미소시루"),
    Sushi("스시"),
    Katsudon("가츠동"),
    Onigiri("오니기리"),
    High_Rice("하이라이스"),
    Ramen("라멘"),
    Okonomiyakki("오코노미야끼");


    private String menu;
    JapaneseFood(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return menu;
    }

    public static JapaneseFood getMenuInfo(String testValue) {
        for (JapaneseFood menu : JapaneseFood.values()) {
            if (menu.toString().equals(testValue)) {
                return menu;
            }
        }
        return null;
    }
}
