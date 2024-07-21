package menu.constants.Menu;

import java.awt.*;

public enum AsianFood {
    Pad_thai("팟타이"),
    kao_pad("카오 팟"),
    nasi_goreng("나시고렝"),
    pineapple_fried_rice("파인애플 볶음밥"),
    rice_noodles("쌀국수"),
    tom_yam_kung("똠얌꿍"),
    banh_mi("반미"),
    Vietnamese_spring_rolls("월남쌈"),
    bun_cha("분짜");


    private String menu;
    AsianFood(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return menu;
    }

    public static AsianFood getMenuInfo(String testValue) {
        for (AsianFood menu : AsianFood.values()) {
            if (menu.toString().equals(testValue)) {
                return menu;
            }
        }
        return null;
    }
}
