package menu.enums;

public enum InputMessage {

    INPUT_COACH_NAMES_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_HATE_FOODS_MESSAGE("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputMessage(final String message) {
        this.message = message;
    }

    public String valueOf() {
        return message;
    }
}
