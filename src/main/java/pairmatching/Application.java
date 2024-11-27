package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.MatchingResult;

public class Application {
    public static void main(String[] args) {
        PairMatchingController pairMatchingController = new PairMatchingController(new MatchingResult());
        pairMatchingController.run();
    }
}
