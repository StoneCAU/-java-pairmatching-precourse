package pairmatching.controller;

import java.util.List;
import pairmatching.util.CrewLoader;

public class PairMatchingController {
    public void run() {

    }

    private List<String> getBackendCrew() {
        return CrewLoader.loadBackendCrew();
    }

    private List<String> getFrontendCrew() {
        return CrewLoader.loadFrontendCrew();
    }
}
