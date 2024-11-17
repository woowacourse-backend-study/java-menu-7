package menu.error;

public enum ErrorMessage {

    UNDIVIDED_NAME_BY_COMMA("[ERROR] 코치 이름은 콤마로 구분해야 합니다."),
    INVALID_NUMBER_OF_COACH("[ERROR] 코치는 최소 2명, 최대 5명이어야 합니다."),
    INVALID_NUMBER_OF_HATE_FOODS("[ERROR] 싫어하는 음식은 2개 이하여야 합니다."),
    INVALID_COACH_NAME_LENGTH("[ERROR] 코치 이름은 2글자 이상 4글자 이하여야 합니다."),
    NOT_EXISTS_MENU("[ERROR] 존재하지 않는 메뉴입니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String valueOf() {
        return message;
    }
}
