package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.Menu.*;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RecommendMenu {
    private Coaches coaches;

    private Map<MenuKind, Integer> weekKindCount;
    private List<MenuKind> weekKinds;

    public RecommendMenu(Coaches coaches) {
        this.coaches = coaches;
        weekKindCount = new HashMap<>();
        weekKinds = new ArrayList<>();

        MenuKind[] kinds = MenuKind.values();
        for (int i = 0; i < kinds.length; i++) {
            weekKindCount.put(kinds[i], 0);
        }
    }

    public void recommend() {
        for (int i = 0; i < 5; i++) {
            MenuKind kind = recommendDayCategory();
            coaches.recommendFood(kind);
        }
    }

    private MenuKind recommendDayCategory() {
        MenuKind kind;
        do{
            kind = getRandomCategory();
        } while(weekKindCount.get(kind) >= 2);

        weekKindCount.put(kind, weekKindCount.get(kind)+1);
        weekKinds.add(kind);

        return kind;
    }

    private MenuKind getRandomCategory() {
        int categoryNum = Randoms.pickNumberInRange(1, 5);

        MenuKind[] values = MenuKind.values();
        return values[categoryNum-1];
    }

    @Override
    public String toString() {
        String result = "[ 카테고리 | ";
        for (int i = 0; i < weekKinds.size() - 1; i++) {
            result += weekKinds.get(i) + " | ";
        }

        result += weekKinds.get(weekKinds.size()-1) + " ]\n";
        return result + coaches.toString();
    }
}
