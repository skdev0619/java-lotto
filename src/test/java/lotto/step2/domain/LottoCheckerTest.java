package lotto.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoCheckerTest {

    @DisplayName("로또 당첨 번호와 일치한 갯수를 확인한다")
    @Test
    void matchWinningNumber(){
        LottoChecker checker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));

        int matchNumberCount = checker.matchWinningNumber(lotto);

        Assertions.assertThat(matchNumberCount).isEqualTo(3);
    }
}