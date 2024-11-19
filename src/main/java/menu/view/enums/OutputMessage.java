package menu.view.enums;

public enum OutputMessage {

    START_MESSAGE("점심 메뉴 추천을 시작합니다."),
    RESULT_MESSAGE("메뉴 추천 결과입니다."),
    RESULT_HEADER("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    RESULT_FOOTER("추천을 완료했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
