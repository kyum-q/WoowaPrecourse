package menu.view;

import menu.constants.PrintMessage;
import menu.model.RecommendMenu;

public class OutputView {
    public void printServiceStartMessage() {
        System.out.println(PrintMessage.PRINT_START_WORD);
        System.out.println();
    }

    public void printRecommendResult(RecommendMenu recommendMenu) {
        System.out.println(PrintMessage.PRINT_ENDING_WORD_START);
        System.out.println(PrintMessage.PRINT_ENDING_WORD_CATEGORY);
        System.out.println(recommendMenu.toString());
        System.out.println(PrintMessage.PRINT_ENDING_WORD_LAST);
    }
}
