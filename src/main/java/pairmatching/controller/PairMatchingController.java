package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingResult;
import pairmatching.domain.Pairs;
import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.MatchingInfo;
import pairmatching.domain.enums.Mission;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;
import pairmatching.util.CrewLoader;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private MatchingResult matchingResult;

    public PairMatchingController(MatchingResult matchingResult) {
        this.matchingResult = matchingResult;
    }

    public void run() {
        String selection;

        do {
            selection = selectMainMenu();
            OutputView.printCourseInformation();
            if (selection.equals("1")) pairMatching();
            if (selection.equals("2")) viewPairMatchingResult();
            if (selection.equals("3")) matchingResult = resetMatchingResult();
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

        Pairs pairs = getPairs(matchingInfo, crewNames);
        OutputView.printPairMatchingResult(pairs);
    }

    private MatchingInfo getMatchingInfo() {
        while (true) {
            try {
                List<String> matchingStr = selectMatching();
                Course course = Course.findByCourseName(matchingStr.get(0));
                Level level = Level.findByLevelName(matchingStr.get(1));
                Mission mission = Mission.findByLevelAndMissionName(level, matchingStr.get(2));
                return MatchingInfo.findByCourseAndMission(course, mission);
            } catch (PairMatchingException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Pairs getPairs(MatchingInfo matchingInfo, List<String> crewNames) {
        if (matchingResult.hasResult(matchingInfo)) {
            String reply = getReply();
            if (reply.equals("네")) return reMatching(matchingInfo, crewNames);
            return matchingResult.findByInfo(matchingInfo);
        }

        Pairs pairs = new Pairs(matchingResult, matchingInfo, crewNames);
        matchingResult.save(matchingInfo, pairs);
        return pairs;
    }

    private String getReply() {
        while (true) {
            try {
                String reply = InputView.inputYesOrNo();
                return InputValidator.validateYesOrNo(reply);
            } catch (PairMatchingException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
    private Pairs reMatching(MatchingInfo matchingInfo, List<String> crewNames) {
        Pairs pairs = new Pairs(matchingResult, matchingInfo, crewNames);
        matchingResult.save(matchingInfo, pairs);

        return pairs;
    }

    private List<String> getCrewNames(MatchingInfo matchingInfo) {
        if (matchingInfo.getCourse() == Course.BACKEND) return CrewLoader.loadBackendCrew();
        return CrewLoader.loadFrontendCrew();
    }

    private void viewPairMatchingResult() {
        while (true) {
            try {
                MatchingInfo matchingInfo = getMatchingInfo();
                Pairs pairs = matchingResult.findResult(matchingInfo);
                OutputView.printPairMatchingResult(pairs);
                return;
            } catch (PairMatchingException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private MatchingResult resetMatchingResult() {
        MatchingResult newMatchingResult = new MatchingResult();
        OutputView.printResetMessage();

        return newMatchingResult;
    }
}
