package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.Menu.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coaches {
    private List<Coach> coaches;
    public Coaches() {
        coaches = new ArrayList<>();
    }

    public void add(String name, List<String> dontEatMenu) {
        coaches.add(new Coach(name, dontEatMenu));
    }

    public void recommendFood(MenuKind kind) {
        for (int i = 0; i < coaches.size(); i++) {
            boolean isCheckMenu = false;
            while(!isCheckMenu) {
                isCheckMenu = coaches.get(i).setMenu(getMenu(kind));
            }
        }
    }

    private String getMenu(MenuKind kind) {
        List<String> menus = null;
        if(kind.toString().equals("일식"))
            menus = List.of(Arrays.toString(JapaneseFood.values()));
        if(kind.toString().equals("한식"))
            menus = List.of(Arrays.toString(KoreanFood.values()));
        if(kind.toString().equals("중식"))
            menus = List.of(Arrays.toString(ChineseFood.values()));
        if(kind.toString().equals("아시안"))
            menus = List.of(Arrays.toString(AsianFood.values()));
        if(kind.toString().equals("양식"))
            menus = List.of(Arrays.toString(WesternFood.values()));

        return Randoms.shuffle(menus).get(0);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < coaches.size(); i++) {
            result += coaches.get(i);
        }
        return result;
    }
}
