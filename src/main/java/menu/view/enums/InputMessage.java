package menu.view.enums;

public enum InputMessage {

    ENTER_COACH_NAME_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
    ENTER_UN_EATING_MENU_MESSAGE("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
