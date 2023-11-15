package christmas.validator;

import christmas.constant.ErrorMessage;
import christmas.constant.event.EventConstant;

public class DateValidator {
    private int date;
    private ErrorMessage errorMessage;

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
        EventConstant minDate = EventConstant.EVENT_MIN_DATE;
        EventConstant maxDate = EventConstant.EVENT_MAX_DATE;
        try {
            if(date < minDate.value() || date > maxDate.value()) {
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
        return errorMessage.toString();
    }
}
