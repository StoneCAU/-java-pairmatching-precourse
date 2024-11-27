package pairmatching.view;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.domain.Pairs;
import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.Mission;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DELIMITER = " | ";

    private static final String SELECT_PLEASE = "기능을 선택하세요.";
    private static final String FIRST_MAIN_MENU = "1. 페어 매칭";
    private static final String SECOND_MAIN_MENU = "2. 페어 조회";
    private static final String THIRD_MAIN_MENU = "3. 페어 초기화";
    private static final String QUIT_MENU = "Q. 종료";

    private static final String DIVIDER = "############################################";
    private static final String COURSE = "과정 : " + Stream.of(Course.values()).map(Course::getName).collect(
            Collectors.joining(DELIMITER));
    private static final String MISSION_TITLE = "미션 : ";

    private static final String MATCHING_RESULT_TITLE = "페어 매칭 결과입니다.";
    private static final String RESET_MESSAGE = "초기화 되었습니다.";

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

    public static void printCourseInformation() {
        printNewLine();
        System.out.println(DIVIDER);
        System.out.println(COURSE);
        System.out.println(MISSION_TITLE);
        printMissions();
        System.out.println(DIVIDER);
    }

    public static void printErrorMessage(String message) {
        printNewLine();
        System.out.println(message);
    }

    public static void printPairMatchingResult(Pairs pairs) {
        printNewLine();
        System.out.println(MATCHING_RESULT_TITLE);
        pairs.getPairs()
                .forEach(System.out::println);
    }

    public static void printResetMessage() {
        printNewLine();
        System.out.println(RESET_MESSAGE);
    }

    private static void printMissions() {
        Stream.of(Level.values()).map(level -> "  - " + level.getName() + ": " + getMissionDetails(level)).forEach(System.out::println);
    }

    private static String getMissionDetails(Level level) {
        return Stream.of(Mission.values()).filter(mission -> mission.getLevel() == level)
                .map(Mission::getMissionName).collect(
                        Collectors.joining(DELIMITER));
    }
}
