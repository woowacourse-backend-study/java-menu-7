package menu.controller;

import java.util.function.Supplier;
import menu.domain.Coaches;
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

        Coaches coaches = doLoop(this::getCoachNames);
        System.out.println(coaches);
    }

    private Coaches getCoachNames() {
        String input = inputView.enterCoach();
        return Coaches.from(input);
    }

    private <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
