package lotto.domain;

import lotto.exceptions.InvalidLottoNumberException;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    private static final LottoNumber[] lottoNumbers = new LottoNumber[MAX_LOTTO_NUMBER + 1];

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers[i] = new LottoNumber(i);
        }
    }

    public static LottoNumber of(int number) {
        lottoNumberExceptionHandler(number);
        return lottoNumbers[number];
    }

    private static void lottoNumberExceptionHandler(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException();
        }
    }

    public static LottoNumber of(String number) {
        return of(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public int toInt() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber nextLottoNumber) {
        return Integer.compare(this.number, nextLottoNumber.number);
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
