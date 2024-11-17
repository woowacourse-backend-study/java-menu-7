package menu.enums;

public enum OutputMessage {

    START_MENU_RECOMMEND_MESSAGE("점심 메뉴 추천을 시작합니다.\n"),
    MENU_RECOMMEND_RESULT_MESSAGE("메뉴 추천 결과입니다."),
    DAYS_MESSAGE("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    COMPLETE_MENU_RECOMMEND_MESSAGE("추천을 완료했습니다.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String valueOf() {
        return message;
    }
}
