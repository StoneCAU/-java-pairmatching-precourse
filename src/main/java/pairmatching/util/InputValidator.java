package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.Mission;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;

public class InputValidator {
    private static final int MIN_MENU = 1;
    private static final int MAX_MENU = 3;
    private static final String QUIT_MENU = "Q";
    private static final String DELIMITER = ", ";

    public static void validateMainMenu(String input) {
        if (input.equals(QUIT_MENU)) {
            return;
        }

        int selection = parseNumber(input);

        if (!isValidBound(selection)) {
            throw new PairMatchingException(ErrorMessage.INVALID_MENU_INPUT);
        }
    }

    public static List<String> validateMatchingInfo(String input) {
        List<String> parsedString = Arrays.asList(input.split(DELIMITER));
        if (parsedString.size() != 3) {
            throw new PairMatchingException(ErrorMessage.INVALID_INPUT);
        }
        validateParsedString(parsedString);

        return parsedString;
    }

    private static void validateParsedString(List<String> parsedString) {
        if (!isValidCourse(parsedString.get(0)) || !isValidLevel(parsedString.get(1)) || !isValidMission(
                parsedString.get(1), parsedString.get(2))) {
            throw new PairMatchingException(ErrorMessage.INVALID_INPUT);
        }
    }

    private static boolean isValidCourse(String input) {
        return Arrays.stream(Course.values()).anyMatch(course -> course.getName().equals(input));
    }

    private static boolean isValidLevel(String input) {
        return Arrays.stream(Level.values()).anyMatch(level -> level.getName().equals(input));
    }

    private static boolean isValidMission(String level, String missionName) {
        return Arrays.stream(Mission.values()).filter(mission -> mission.getLevel().getName().equals(level))
                .anyMatch(mission -> mission.getMissionName().equals(missionName));
    }

    private static int parseNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new PairMatchingException(ErrorMessage.INVALID_MENU_INPUT);
        }

        return Integer.parseInt(input);
    }

    private static boolean isValidBound(int selection) {
        return selection >= MIN_MENU && selection <= MAX_MENU;
    }
}
