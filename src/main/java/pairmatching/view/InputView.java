package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String NEW_LINE = System.lineSeparator();

    public static String inputSelection() {
        return Console.readLine();
    }

    private static void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
