package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.InputCarNames;
import racingcar.util.InputTryCount;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Disabled("완성된 이후 테스트 할 것")
    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Disabled("완성된 이후 테스트 할 것")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_목록_테스트1() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = "pobi,woni,jun";

        List<String> carList = inputCarNames.parsingName(input);

        assertThat(carList).hasSize(3).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_목록_테스트2() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = "안녕,잘지냈니,잘가,다음에,또,보자";

        List<String> carList = inputCarNames.parsingName(input);

        assertThat(carList).hasSize(6).containsExactly("안녕", "잘지냈니", "잘가", "다음에", "또", "보자");
    }

    @Test
    void 자동차_목록_테스트3() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = "one,일,1";

        List<String> carList = inputCarNames.parsingName(input);

        assertThat(carList).hasSize(3).containsExactly("one", "일", "1");
    }

    @DisplayName("자동차 이름이 공백일 시 예외테스트")
    @Test
    void 자동차_목록_예외_테스트1() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = "pobi,,jun";

        assertThatThrownBy(() -> inputCarNames.parsingName(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5글자 이상일 시 예외테스트")
    @Test
    void 자동차_목록_예외_테스트2() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = "pobi,woniwoni,jun";

        assertThatThrownBy(() -> inputCarNames.parsingName(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 중복일 시 예외테스트")
    @Test
    void 자동차_목록_예외_테스트3() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = "pobi,pobi,jun";

        assertThatThrownBy(() -> inputCarNames.parsingName(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 예외테스트1")
    @Test
    void 자동차_목록_예외_테스트4() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = "pobi,woni,jun,";

        assertThatThrownBy(() -> inputCarNames.parsingName(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 예외테스트2")
    @Test
    void 자동차_목록_예외_테스트5() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = ",pobi,woni,jun";

        assertThatThrownBy(() -> inputCarNames.parsingName(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차리스트 값이 잘못된 패턴일 시 예외테스트3")
    @Test
    void 자동차_목록_예외_테스트6() {
        InputCarNames inputCarNames = new InputCarNames();
        String input = ",pobi,woni,jun,";

        assertThatThrownBy(() -> inputCarNames.parsingName(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 숫자인지 테스트1")
    @Test
    void 시도_횟수_테스트1() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "4";

        int number = inputTryCount.parseNumber(input);

        assertThat(number).isEqualTo(4);
    }

    @DisplayName("시도 횟수의 입력값이 숫자인지 테스트2")
    @Test
    void 시도_횟수_테스트2() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "13";

        int number = inputTryCount.parseNumber(input);

        assertThat(number).isEqualTo(13);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트1")
    @Test
    void 시도_횟수_테스트3() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "abc";

        assertThatThrownBy(() -> inputTryCount.parseNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트2")
    @Test
    void 시도_횟수_테스트4() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "가나다";

        assertThatThrownBy(() -> inputTryCount.parseNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트3")
    @Test
    void 시도_횟수_테스트5() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "!@#";

        assertThatThrownBy(() -> inputTryCount.parseNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 숫자가 아닐 시 예외테스트3")
    @Test
    void 시도_횟수_테스트6() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "a가!";

        assertThatThrownBy(() -> inputTryCount.parseNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 음수일 시 예외테스트")
    @Test
    void 시도_횟수_테스트7() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "-6";

        assertThatThrownBy(() -> inputTryCount.parseNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수의 입력값이 0 일 시 예외테스트")
    @Test
    void 시도_횟수_테스트8() {
        InputTryCount inputTryCount = new InputTryCount();
        String input = "0";

        assertThatThrownBy(() -> inputTryCount.parseNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
