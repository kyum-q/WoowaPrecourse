package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.OrderConstant;

public class DateValidator {
    private int date;
    private OrderConstant minDate, maxDate;
    private ErrorMessage errorMessage;

    public DateValidator() {
        minDate = OrderConstant.MIN_DATE;
        maxDate = OrderConstant.MAX_DATE;
    }

    public boolean validate(String s) {
        return validOtherString(s) && validLessMinOverMax(date);
    }

    private boolean validOtherString(String s) {
        try {
            date = Integer.parseInt(s);
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_DATE;
            return false;
        }
        return true;
    }

    public boolean validLessMinOverMax(int date) {
        try {
            if(date < minDate.getNumber() || date > maxDate.getNumber()) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_DATE;
            return false;
        }
        return true;
    }

    public int getDate() {
        return date;
    }

    public String getErrorMessage() {
        if(errorMessage==null)
            return "";
        return errorMessage.getMessage();
    }
}
