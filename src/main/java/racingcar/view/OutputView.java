package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void resultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void roundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getCurrentPosition());
        }
        System.out.println();
    }

    public static void winnerMessage(String winnerList) {
        System.out.println("최종 우승자 : " + winnerList);
    }
}