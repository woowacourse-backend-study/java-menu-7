package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private InputView inputView;
    private OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void process() {
        outputView.printStartMessage();


    }

    private void getCoachNames() {
        String input = inputView.enterCoach();
    }
}
