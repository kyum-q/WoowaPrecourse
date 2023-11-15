package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.event.EventConstant;
import christmas.constant.menu.MenuKind;
import christmas.model.Menu;

import java.util.*;

public class OrderMenuValidator {
    private LinkedHashMap<String, Integer> orders;
    private List<Menu> menus;
    private ErrorMessage errorMessage;

    public boolean validate(String s) {
        orders = new LinkedHashMap<>();
        menus = new ArrayList<>();

        s = s.replaceAll(" ", "");
        return validOtherString(s) && validContainUsingMenu(orders) &&
                validLessMinOverMax(menus) && validOrderOnlyDrink(menus);
    }

    private boolean validOtherString(String s) {
        try {
            List<String> orderStrings = Arrays.stream(s.split(",", -1)).toList();
            orderStrings.forEach(this::settingOrderMap);
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_ORDER;
            return false;
        }
        return true;
    }

    private void settingOrderMap(String orderString) {
        String[] order = orderString.split("-", -1);

        int size = Integer.parseInt(order[1]);
        if(size <= 0) // 사이즈 체크
            throw new IllegalArgumentException();

        if(orders.containsKey(order[0])) // 중복 체크
            throw new IllegalArgumentException();

        orders.put(order[0], size);
    }

    private boolean validContainUsingMenu(HashMap<String, Integer> orders) {
        try {
            orders.forEach((name, size) -> menus.add(new Menu(name, size)));
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_ORDER;
            return false;
        }
        return true;
    }

    private boolean validLessMinOverMax(List<Menu> menus) {
        EventConstant minOrder = EventConstant.EVENT_MIN_ORDER;
        EventConstant maxOrder = EventConstant.EVENT_MAX_ORDER;
        int size = menus.stream().mapToInt(Menu::getSize).sum();
        try {
            if(size < minOrder.value() || size > maxOrder.value()) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_OVER_MAX_SIZE;
            return false;
        }
        return true;
    }

    private boolean validOrderOnlyDrink(List<Menu> menus) {
        try {
            if(menus.stream().allMatch(menu -> menu.checkKind(MenuKind.DRINK)))
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_OVER_ONLY_DRINK;
            return false;
        }
        return true;
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public String getErrorMessage() {
        if(errorMessage==null)
            return "";
        return errorMessage.toString();
    }
}
