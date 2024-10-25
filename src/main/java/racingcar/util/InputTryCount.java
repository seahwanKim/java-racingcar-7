package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.TryCountValidiator;

public class InputTryCount {

    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public int inputCount() {
        System.out.println(INPUT_TRY_COUNT);
        String tryCount = Console.readLine();

        return parseNumber(tryCount);
    }

    public int parseNumber(String tryCount) {

        TryCountValidiator check = new TryCountValidiator();

        try {
            int count = Integer.parseInt(tryCount);

            check.positiveNumber(count);

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
