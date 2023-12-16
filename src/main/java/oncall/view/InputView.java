package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.constants.ErrorMessage;
import oncall.constants.RequestMessage;
import oncall.model.MonthWeek;
import oncall.validator.MonthWeekValidator;
import oncall.validator.SequenceValidator;

import java.util.List;

public class InputView {
    private ErrorMessage errorMessage;
    private MonthWeekValidator monthWeekValidator;
    private SequenceValidator sequenceValidator;

    public InputView() {
        errorMessage = ErrorMessage.ERROR_MESSAGE;
    }
    public MonthWeek requestMonthWeek() {
        monthWeekValidator = new MonthWeekValidator();

        System.out.print(RequestMessage.REQUEST_MONTH_DAY);
        String input = Console.readLine();

        while (!monthWeekValidator.valid(input)) {
            System.out.println(errorMessage);
            System.out.print(RequestMessage.REQUEST_MONTH_DAY);
            input = Console.readLine();
        }

        return monthWeekValidator.getResult();
    }

    public List<List<String>> requestWeeklyAndWeekend() {
        sequenceValidator = new SequenceValidator();

        System.out.print(RequestMessage.REQUEST_WEEKDAY_SEQUENCE);
        String weekly = Console.readLine();
        System.out.print(RequestMessage.REQUEST_WEEKEND_SEQUENCE);
        String weekend = Console.readLine();

        while (!(sequenceValidator.validWeekly(weekly) && sequenceValidator.validWeekend(weekend))) {
            System.out.println(errorMessage);
            System.out.print(RequestMessage.REQUEST_WEEKDAY_SEQUENCE);
            weekly = Console.readLine();
            System.out.print(RequestMessage.REQUEST_WEEKEND_SEQUENCE);
            weekend = Console.readLine();
        }

        return sequenceValidator.getResult();
    }
}
