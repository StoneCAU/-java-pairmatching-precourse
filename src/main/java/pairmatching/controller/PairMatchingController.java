package pairmatching.controller;

import java.util.List;
import pairmatching.exception.PairMatchingException;
import pairmatching.util.CrewLoader;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    public void run() {
        String selection;

        do {
            selection = selectMainMenu();
            OutputView.printCourseInformation();
            if (selection.equals("1")) pairMatching();
        } while (!selection.equals("Q"));
    }

    private String selectMainMenu() {
        OutputView.printMainMenu();
        while (true) {
            try {
                String input = InputView.inputSelection();
                InputValidator.validateMainMenu(input);
                return input;
            } catch (PairMatchingException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> selectMatching() {
        while (true) {
            try {
                String input = InputView.inputMatchingInfo();
                return InputValidator.validateMatchingInfo(input);
            } catch (PairMatchingException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void pairMatching() {
        List<String> matchingInfo = selectMatching();

    }


    private List<String> getBackendCrew() {
        return CrewLoader.loadBackendCrew();
    }

    private List<String> getFrontendCrew() {
        return CrewLoader.loadFrontendCrew();
    }
}
