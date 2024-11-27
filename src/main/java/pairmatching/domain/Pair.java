package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private static final String DELIMITER = " : ";

    private List<Crew> matchedCrews;

    public Pair(List<Crew> matchedCrews) {
        this.matchedCrews = matchedCrews;
    }

    public List<Crew> getMatchedCrews() {
        return matchedCrews;
    }

    @Override
    public String toString() {
        return matchedCrews.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}
