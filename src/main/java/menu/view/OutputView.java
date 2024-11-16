package menu.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printResult(String categoryResult, String recommendMenuResult) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(categoryResult);
        System.out.println(recommendMenuResult);
        System.out.println("추천을 완료했습니다.");
    }

}
