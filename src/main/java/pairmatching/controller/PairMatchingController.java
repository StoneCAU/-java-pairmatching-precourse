package pairmatching.controller;

import java.util.List;
import pairmatching.exception.PairMatchingException;
import pairmatching.util.CrewLoader;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    public void run() {
        String selection = selectMainMenu();
        OutputView.printCourseInformation();
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

    private List<String> getBackendCrew() {
        return CrewLoader.loadBackendCrew();
    }

    private List<String> getFrontendCrew() {
        return CrewLoader.loadFrontendCrew();
    }
}
