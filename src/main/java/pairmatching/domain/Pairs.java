package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private final MatchingInfo matchingInfo;
    private final List<Pair> pairs;

    public Pairs(MatchingInfo matchingInfo, List<String> crewNames) {
        this.pairs = generatePairList(matchingInfo, crewNames);
        this.matchingInfo = matchingInfo;
    }

    public MatchingInfo getMatchingInfo() {
        return matchingInfo;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    private List<Pair> generatePairList(MatchingInfo matchingInfo, List<String> crewNames) {
        List<Crew> crews = Crew.getCrews(matchingInfo, crewNames);
        List<Pair> pairList = new ArrayList<>();

        while (crews.size() > 3) {
            pairList.add(generatePair(crews));
            crews.remove(0);
            crews.remove(0);
        }

        pairList.add(new Pair(crews));

        return pairList;
    }

    private Pair generatePair(List<Crew> crews) {
        List<Crew> matchedCrews = new ArrayList<>();
        matchedCrews.add(crews.get(0));
        matchedCrews.add(crews.get(1));

        return new Pair(matchedCrews);
    }

}
