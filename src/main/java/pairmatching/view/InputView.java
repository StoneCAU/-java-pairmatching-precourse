package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String NEW_LINE = System.lineSeparator();

    public static String inputSelection() {
        return Console.readLine();
    }

    public static String inputMatchingInfo() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        return Console.readLine();
    }

    private static void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
