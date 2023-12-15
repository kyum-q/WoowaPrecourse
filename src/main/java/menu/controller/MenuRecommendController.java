package menu.controller;

import menu.model.Coaches;
import menu.model.RecommendMenu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendController {
    private OutputView outputView;
    private InputView inputView;
    private RecommendMenu recommendMenu;

    public MenuRecommendController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void startRecommend() {
        outputView.printServiceStartMessage();
        recommendMenu = new RecommendMenu(settingCoach());
        recommendMenu.recommend();
        outputView.printRecommendResult(recommendMenu);
    }

    public Coaches settingCoach() {
        Coaches coaches = new Coaches();
        List<String> coach = inputView.requestCoachNames();
        for (int i = 0; i < coach.size(); i++) {
            List<String> dontEat = inputView.requestCoachDontEat(coach.get(i));
            coaches.add(coach.get(i), dontEat);
        }
        return coaches;
    }

}
