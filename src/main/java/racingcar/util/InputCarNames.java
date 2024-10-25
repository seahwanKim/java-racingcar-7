package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NameValidiator;

import java.util.List;

public class InputCarNames {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public List<String> inputNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String cars = Console.readLine();

        return parsingName(cars);
    }

    private List<String> parsingName(String cars) {
        NameValidiator check = new NameValidiator();

        List<String> carsList = List.of(cars.split(","));

        check.rightNameList(cars);
        check.nameLength(carsList);
        check.nameOverlap(carsList);

        return carsList;
    }
}
