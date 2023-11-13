package christmas.view;
import christmas.constant.PrintMessage;
import christmas.constant.event.EventConstant;
import christmas.model.Menu;
import christmas.model.event.Badge;
import christmas.model.event.Event;

import java.text.DecimalFormat;
import java.util.List;

public class Output {
    public void printFirstMent(int date) {
        System.out.println(EventConstant.EVENT_MONTH + "월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printTotalMenu(List<Menu> menus) {
        System.out.println(PrintMessage.TOTAL_MENU);
        for(Menu menu : menus) {
            System.out.println(menu.getMenuName() + " "  + menu.getSize() + "개");
        }
        System.out.println();
    }

    public void printBeforeDiscountTotalPrice(int price) {
        System.out.println(PrintMessage.BEFORE_DISCOUNT_TOTAL_PRICE);
        System.out.printf(getPriceString(price));
        System.out.println();
    }

    public void printGiftMenu() {
        System.out.println(PrintMessage.GIFT_MENU);
        System.out.println();
        System.out.println();
    }

    public void printBenefit(List<Event> events) {
        System.out.println(PrintMessage.BENEFIT);
        for(Event event : events) {
            System.out.println(event.getEventName() + ": " + getPriceString(event.getDiscountPrice()));
        }
        System.out.println();
    }

    public void printTotalBenefit(int benefit) {
        System.out.println(PrintMessage.TOTAL_BENEFIT);
        System.out.println(benefit);
        System.out.println();
    }

    public void printAfterDiscountTotalPrice(int price) {
        System.out.println(PrintMessage.AFTER_DISCOUNT_TOTAL_PRICE);
        System.out.printf(getPriceString(price));
        System.out.println();
    }

    public void printGiftBadge(Badge badge) {
        System.out.println(PrintMessage.EVENT_BADGE);
        System.out.println(badge.getBadgeName());
    }

    private String getPriceString(int number) {
        // 3의 배수마다 쉼표 추가하는 포맷 설정
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number)  + "원";
    }
}
