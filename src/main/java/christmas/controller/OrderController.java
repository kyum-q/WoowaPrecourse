package christmas.controller;

import christmas.constant.OrderConstant;
import christmas.constant.event.EventConstant;
import christmas.constant.menu.DrinkMenu;
import christmas.model.EventManager;
import christmas.model.Menu;
import christmas.model.OrderCalculate;
import christmas.model.event.Event;
import christmas.view.Input;
import christmas.view.Output;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private final Input input;
    private final Output output;
    private final EventManager eventManager;
    private final OrderCalculate calculate;
    private int date;
    private List<Menu> orderMenus;
    private int beforeDiscountTotalPrice, benefitPrice;
    private List<Event> events;

    public OrderController() {
        input = new Input();
        output = new Output();
        eventManager = new EventManager();
        calculate = new OrderCalculate();
    }

    public void order() {
        date = input.readDate();
        orderMenus = input.readOrder();

        beforeDiscountTotalPrice = calculate.getBeforeDiscountTotalPrice(orderMenus);
        eventManager.settingEvent(date, orderMenus, beforeDiscountTotalPrice);

        benefitPrice = calculate.getBenefitTotalPrice(eventManager.getEvents());
        eventManager.setBadgeEvent(benefitPrice);

        printResult();
    }

    private void printResult() {
        output.printFirstMent(date);
        output.printTotalMenu(orderMenus);
        output.printBeforeDiscountTotalPrice(beforeDiscountTotalPrice);
        output.printGiftMenu(eventManager.containGift());
        output.printBenefit(eventManager.getEvents());
        output.printTotalBenefit(benefitPrice);
        output.printAfterDiscountTotalPrice(calculate.getAfterDiscountTotalPrice
                (eventManager.isGiftEvent(),beforeDiscountTotalPrice,benefitPrice));
        output.printGiftBadge(eventManager.getBadge());
    }



}
