package pairmatching.util;

import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;

public class InputValidator {
    private static final int MIN_MENU = 1;
    private static final int MAX_MENU = 3;
    private static final String QUIT_MENU = "Q";

    public static void validateMainMenu(String input) {
        if (input.equals(QUIT_MENU)) {
            return;
        }

        int selection = parseNumber(input);

        if (!isValidBound(selection)) {
            throw new PairMatchingException(ErrorMessage.INVALID_MENU_INPUT);
        }
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
