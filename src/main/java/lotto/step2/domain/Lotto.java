package lotto.step2.domain;

import java.util.List;

public class Lotto {

    private static final int LIMIT_LOTTO_NUMBER = 45;
    private static final int LIMIT_LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers){
        this.numbers = numbers;
        validateNumbers();
    }

    private void validateNumbers() {
        if(this.isNotValidNumberSize()){
            throw new IllegalArgumentException("로또 숫자는 6개만 선택 가능합니다");
        }

        if(this.hasNonValidNumber()) {
            throw new IllegalArgumentException("로또 숫자는 1-45이내의 숫자만 선택 가능합니다");
        }

        if(this.duplicateNumber()){
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다");
        }
    }

    private boolean isNotValidNumberSize(){
        return this.numbers.size() != LIMIT_LOTTO_COUNT;
    }

    private boolean hasNonValidNumber() {
        long nonValidNumCount = numbers
                .stream()
                .filter(this::isNotValidNumber)
                .count();

        return nonValidNumCount > 0;
    }

    private boolean isNotValidNumber(int number) {
        return number > LIMIT_LOTTO_NUMBER || number <= 0;
    }

    private boolean duplicateNumber() {
        long numberSize = this.numbers.stream()
                .distinct()
                .count();

        return numberSize != LIMIT_LOTTO_COUNT;
    }

    public boolean hasNumber(Integer winningNumber) {
        return this.numbers.contains(winningNumber);
    }
}
