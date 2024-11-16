package menu.view;

import menu.domain.Coaches;

public class OutputView {

    public void startService() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void showRecommendResult(Coaches coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(coaches.toString());
        System.out.println("\n추천을 완료했습니다.");
    }
}
