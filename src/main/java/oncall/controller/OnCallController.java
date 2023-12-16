package oncall.controller;

import oncall.model.MonthWeek;
import oncall.model.SequenceManagement;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;

public class OnCallController {
    private InputView inputView;
    private OutputView outputView;

    public OnCallController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void makeOnCall() {
        MonthWeek monthWeek = inputView.requestMonthWeek();
        List<List<String>> lists = inputView.requestWeeklyAndWeekend();
        SequenceManagement management = new SequenceManagement(monthWeek, lists.get(0), lists.get(1));
        management.setOnCall();
        outputView.printResult(management);
    }
}
