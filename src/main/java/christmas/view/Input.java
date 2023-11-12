package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.RequestMessage;
import christmas.validator.DateValidator;

public class Input {
    private DateValidator dateValidator;

    public Input() {
        dateValidator = new DateValidator();
    }

    public int readDate() {
        String date;

        System.out.println(RequestMessage.REQUEST_FIRST_MENT.getMessage());
        System.out.print(RequestMessage.REQUEST_DATE.getMessage());
        do {
            System.out.println(dateValidator.getErrorMessage());
            date = Console.readLine();
        } while (!dateValidator.validate(date));
        System.out.println();

        return dateValidator.getDate();
    }

    public String readOrder() {
        return "";
    }

}
