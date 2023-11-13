package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.menu.MenuKind;
import christmas.constant.OrderConstant;
import christmas.model.Menu;

import java.util.*;

public class OrderMenuValidator {
    private LinkedHashMap<String, Integer> orders;
    private List<Menu> menus;
    private OrderConstant minOrder, maxOrder;
    private ErrorMessage errorMessage;

    public OrderMenuValidator() {
        minOrder = OrderConstant.MIN_ORDER;
        maxOrder = OrderConstant.MAX_ORDER;
    }
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
            errorMessage = ErrorMessage.ERROR_ORDER_OTHER_DATE;
            return false;
        }
        return true;
    }

    private void settingOrderMap(String orderString) {
        String[] order = orderString.split("-", -1);
        orders.put(order[0], Integer.parseInt(order[1]));
    }

    private boolean validContainUsingMenu(HashMap<String, Integer> orders) {
        try {
            orders.forEach((name, size) -> menus.add(new Menu(name, size)));
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_ORDER_NOT_EXIST_MENU;
            return false;
        }
        return true;
    }

    public boolean validLessMinOverMax(List<Menu> menus) {
        int size = menus.stream().mapToInt(Menu::getSize).sum();
        try {
            if(size < minOrder.getNumber() || size > maxOrder.getNumber()) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_OVER_MAX_SIZE;
            return false;
        }
        return true;
    }

    public boolean validOrderOnlyDrink(List<Menu> menus) {
        try {
            if(menus.stream().allMatch(menu -> menu.getKind() == MenuKind.DRINK))
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_OVER_ONLY_DRINK;
            return false;
        }
        return true;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public String getErrorMessage() {
        if(errorMessage==null)
            return "";
        return errorMessage.getMessage();
    }
}
