package menu.validator;

import menu.constants.ErrorMessage;
import menu.constants.Menu.*;
import menu.constants.RecommendConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DontEatValidator {
    private List<String> menus;
    private ErrorMessage errorMessage;
    private int minMenuCount, maxMenuCount;
    public DontEatValidator() {
        minMenuCount = RecommendConstants.DONT_EAT_MENU_MIN.getNumber();
        maxMenuCount = RecommendConstants.DONT_EAT_MENU_MAX.getNumber();
    }

    public boolean valid(String s) {
        return validMenuZero(s) || (validMenuCount(s) && validWithoutMenu());
    }

    private boolean validMenuZero(String s) {
        menus = new ArrayList<>();
        return s.equals("");
    }
    private boolean validMenuCount(String s) {
        try {
            menus = List.of(s.split(",", -1));
            if(menus.size() < minMenuCount || menus.size() > maxMenuCount) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_DONT_EAT_COUNT;
            return false;
        }
        return true;
    }

    private boolean validWithoutMenu() {
        try {
            if(!menus.stream().allMatch(MenuKind::isCheckContainMenu)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_WITHOUT_MENU;
            return false;
        }
        return true;
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    @Override
    public String toString() {
        return errorMessage.toString();
    }
}

