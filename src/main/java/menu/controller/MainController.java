package menu.controller;

import static menu.domain.Category.ASIAN;
import static menu.domain.Category.CHINESE;
import static menu.domain.Category.JAPANESE;
import static menu.domain.Category.KOREAN;
import static menu.domain.Category.WESTERN;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.UnEatingMenusMapper;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void process() {
        outputView.printStartMessage();

        Coaches coaches = doLoop(this::getCoachNames);

        UnEatingMenusMapper unEatingMenusMapper = generateUnEatingMenusMapper(coaches);
    }

    private Coaches getCoachNames() {
        String input = inputView.enterCoach();
        return Coaches.from(input);
    }

    private Menus getUnEatingMenus(Coach coach) {
        String input = inputView.enterUnEatingMenu(coach);
        return Menus.createUnEatingMenusFrom(input);
    }

    private UnEatingMenusMapper generateUnEatingMenusMapper(Coaches coaches) {
        Map<Coach, Menus> unEatingMenus = new HashMap<>();
        for (Coach coach : coaches.getCoaches()) {
            Menus menus = doLoop(() -> getUnEatingMenus(coach));
            unEatingMenus.put(coach, menus);
        }
        return UnEatingMenusMapper.from(unEatingMenus);
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
