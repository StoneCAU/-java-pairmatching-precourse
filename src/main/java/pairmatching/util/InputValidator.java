package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;

public class InputValidator {
    private static final int MIN_MENU = 1;
    private static final int MAX_MENU = 3;
    private static final String QUIT_MENU = "Q";
    private static final String DELIMITER = ", ";
    private static final String YES = "네";
    private static final String NO = "아니오";

    public static void validateMainMenu(String input) {
        if (input.equals(QUIT_MENU)) {
            return;
        }

        int selection = parseNumber(input);

        if (!isValidBound(selection)) {
            throw new PairMatchingException(ErrorMessage.INVALID_MENU_INPUT);
        }
    }

    public static String validateYesOrNo(String input) {
        if (!input.equals(YES) && !input.equals(NO)) {
            throw new PairMatchingException(ErrorMessage.INVALID_INPUT);
        }
        return input;
    }

    public static List<String> validateMatchingInfo(String input) {
        List<String> parsedString = Arrays.asList(input.split(DELIMITER));
        if (parsedString.size() != 3) {
            throw new PairMatchingException(ErrorMessage.INVALID_INPUT);
        }

        return parsedString;
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
