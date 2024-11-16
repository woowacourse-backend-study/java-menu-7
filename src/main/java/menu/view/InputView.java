package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCoaches() {
        System.out.print("코치의 이름을 입력해주세요. (, 로 구분)");
        return createCoaches(Console.readLine());
    }

    private String createCoaches(String coaches) {
        try {
            return new Coaches()
        }
    }

}
