package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        Set<String> oldSet = new HashSet<>(matchedCrews.stream().map(Crew::getName).collect(Collectors.toSet()));
        Set<String> newSet = new HashSet<>(pair.matchedCrews.stream().map(Crew::getName).collect(Collectors.toSet()));

        return oldSet.equals(newSet);
    }

    @Override
    public int hashCode() {
        return matchedCrews.hashCode();
    }
}
