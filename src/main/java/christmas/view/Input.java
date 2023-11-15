package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.RequestMessage;
import christmas.model.Menu;
import christmas.validator.DateValidator;
import christmas.validator.OrderMenuValidator;

import java.util.List;

public class Input {
    private DateValidator dateValidator;
    private OrderMenuValidator menuValidator;

    public Input() {
        dateValidator = new DateValidator();
        menuValidator = new OrderMenuValidator();
    }

    public int readDate() {
        String date;

        System.out.println(RequestMessage.REQUEST_FIRST_MENT.toString());
        System.out.print(RequestMessage.REQUEST_DATE.toString());
        do {
            System.out.println(dateValidator.getErrorMessage());
            date = Console.readLine();
        } while (!dateValidator.validate(date));

        return dateValidator.getDate();
    }

    public List<Menu> readOrder() {
        String date;

        System.out.print(RequestMessage.REQUEST_ORDER.toString());
        do {
            System.out.println(menuValidator.getErrorMessage());
            date = Console.readLine();
        } while (!menuValidator.validate(date));

        return menuValidator.getMenus();
    }

}
