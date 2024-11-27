package pairmatching.controller;

import java.util.List;
import pairmatching.domain.MatchingResult;
import pairmatching.domain.Pairs;
import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.MatchingInfo;
import pairmatching.domain.enums.Mission;
import pairmatching.exception.PairMatchingException;
import pairmatching.util.CrewLoader;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final MatchingResult matchingResult;

    public PairMatchingController(MatchingResult matchingResult) {
        this.matchingResult = matchingResult;
    }

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
        MatchingInfo matchingInfo = getMatchingInfo();
        List<String> crewNames = getCrewNames(matchingInfo);

        Pairs pairs = new Pairs(matchingInfo, crewNames);
        matchingResult.save(matchingInfo, pairs);
    }

    private MatchingInfo getMatchingInfo() {
        List<String> matchingStr = selectMatching();
        Course course = Course.findByCourseName(matchingStr.get(0));
        Level level = Level.findByLevelName(matchingStr.get(1));
        Mission mission = Mission.findByLevelAndMissionName(level, matchingStr.get(2));
        return MatchingInfo.findByCourseAndMission(course, mission);
    }

    private List<String> getCrewNames(MatchingInfo matchingInfo) {
        if (matchingInfo.getCourse() == Course.BACKEND) return CrewLoader.loadBackendCrew();
        return CrewLoader.loadFrontendCrew();
    }
}
