package menu.util.enums;

public enum ErrorMessage {

    INVALID_COACH_NAME_LENGTH("코치명은 최소 2글자 이상, 최대 4글자 이하 입력해야 합니다."),
    INVALID_COACHES_COUNT("코치는 최소 2명 이상, 최대 5명 이하 입력해야 합니다."),
    INVALID_DUPLICATION_COACH("중복된 코치명을 입력할 수 없습니다."),
    INVALID_UN_EATING_MENU_SIZE("못 먹는 메뉴는 최대 2개까지 입력 가능합니다."),
    MENU_NOT_FOUND("입력하신 메뉴를 전체 메뉴 목록에서 찾을 수 없습니다.");

    private static final String errorHeader = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorHeader + message;
    }
}
