package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constants.RequestMessage;
import menu.validator.CoachNamesValidator;

import java.util.List;

public class InputView {
    public List<String> requestCoachNames() {
        CoachNamesValidator validator = new CoachNamesValidator();

        System.out.println(RequestMessage.REQUEST_COACH_NAMES);
        String input = Console.readLine();

        while(!validator.valid(input)) {
            System.out.println(validator);
            input = Console.readLine();
        }

        return validator.getNames();
    }
}
