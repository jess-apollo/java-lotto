package lotto.view;

import lotto.util.Splitter;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    Splitter splitter = new Splitter();

    public int inputPrice() {
        System.out.println("구입 급액을 입력해주세요.");
        return scanner.nextInt();
    }

    public String[] inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        scanner.nextLine();

        String input = scanner.nextLine();
        return splitter.split(input);
    }
}
