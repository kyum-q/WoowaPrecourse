package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {
    private OutputView outputView;
    private InputView inputView;

    public MenuRecommendController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void startRecommend() {
        outputView.printServiceStartMessage();
        inputView.requestCoachNames();
    }

}
