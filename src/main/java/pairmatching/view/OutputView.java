package pairmatching.view;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();

    private static final String SELECT_PLEASE = "기능을 선택하세요.";
    private static final String FIRST_MAIN_MENU = "1. 페어 매칭";
    private static final String SECOND_MAIN_MENU = "2. 페어 조회";
    private static final String THIRD_MAIN_MENU = "3. 페어 초기화";
    private static final String QUIT_MENU = "Q. 종료";

    private static void printNewLine() {
        System.out.printf(NEW_LINE);
    }

    public static void printMainMenu() {
        printNewLine();
        System.out.println(SELECT_PLEASE);
        System.out.println(FIRST_MAIN_MENU);
        System.out.println(SECOND_MAIN_MENU);
        System.out.println(THIRD_MAIN_MENU);
        System.out.println(QUIT_MENU);
    }

    public static void printErrorMessage(String message) {
        printNewLine();
        System.out.println(message);
    }
}
