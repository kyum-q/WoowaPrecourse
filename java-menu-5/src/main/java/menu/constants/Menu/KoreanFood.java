package menu.constants.Menu;

public enum KoreanFood {
    Gimbap("김밥"),
    Kimchi_stew("김치찌개"),
    Ssambap("쌈밥"),
    Soybean_paste_stew("된장찌개"),
    Bibimbap("비빔밥"),
    Kalguksu("칼국수"),
    Bulgogi("불고기"),
    Tteokbokki("떡볶이"),
    Stir_fried_spicy_pork("제육볶음");


    private String menu;
    KoreanFood(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return menu;
    }

    public static KoreanFood getMenuInfo(String testValue) {
        for (KoreanFood menu : KoreanFood.values()) {
            if (menu.toString().equals(testValue)) {
                return menu;
            }
        }
        return null;
    }
}
