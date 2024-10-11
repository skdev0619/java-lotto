package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BonusBallTest {

    @DisplayName("보너스 볼이 일치하는지 확인 가능하다")
    @Test
    void matchBonusBall(){
        int bonusNumber = 12;
        BonusBall bonusBall = new BonusBall(bonusNumber);

        assertTrue(bonusBall.isBonusNumber(12));
        assertFalse(bonusBall.isBonusNumber(new LottoNumber(11)));
    }
}