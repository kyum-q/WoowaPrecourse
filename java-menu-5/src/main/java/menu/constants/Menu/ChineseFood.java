package menu.constants.Menu;

public enum ChineseFood {
    kanpunggi("깐풍기"),
    stir_fried_noodles("볶음면"),
    dongpa_yuk("동파육"),
    jajangmyeon("짜장면"),
    jjamppong("짬뽕"),
    mapa_tofu("마파두부"),
    sweet_and_sour_pork("탕수육"),
    fried_tomato_eggs("토마토 달걀볶음"),
    red_pepper_japchae("고추잡채");


    private String menu;
    ChineseFood(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return menu;
    }

    public static ChineseFood getMenuInfo(String testValue) {
        for (ChineseFood menu : ChineseFood.values()) {
            if (menu.toString().equals(testValue)) {
                return menu;
            }
        }
        return null;
    }
}
