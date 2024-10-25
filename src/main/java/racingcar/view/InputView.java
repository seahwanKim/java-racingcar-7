package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CAR_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String inputCar() {
        System.out.println(INPUT_CAR_LIST_MESSAGE);
        return Console.readLine();
    }

    public static String inputRound() {
        System.out.println(INPUT_TRY_ROUND_MESSAGE);
        return Console.readLine();
    }
}