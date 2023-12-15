package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.constants.RequestMessage;
import menu.validator.CoachNamesValidator;
import menu.validator.DontEatValidator;

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

        System.out.println();
        return validator.getNames();
    }

    public List<String> requestCoachDontEat(String name) {
        DontEatValidator validator = new DontEatValidator();

        System.out.println(name + RequestMessage.REQUEST_COACH_CANT_EAT_LIST);
        String input = Console.readLine();

        while(!validator.valid(input)) {
            System.out.println(validator);
            input = Console.readLine();
        }

        System.out.println();
        return validator.getMenus();
    }
}
