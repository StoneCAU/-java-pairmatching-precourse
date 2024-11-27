package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.MatchingInfo;
import pairmatching.domain.enums.Mission;

public class Pairs {
    private final MatchingInfo matchingInfo;
    private final List<Pair> pairs;
    private final List<String> crewNames;

    public Pairs(MatchingResult matchingResult, MatchingInfo matchingInfo, List<String> crewNames) {
        this.crewNames = crewNames;
        this.pairs = generatePairList(matchingResult, matchingInfo);
        this.matchingInfo = matchingInfo;
    }

    public MatchingInfo getMatchingInfo() {
        return matchingInfo;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    private List<Pair> generatePairList(MatchingResult matchingResult, MatchingInfo matchingInfo) {
        List<Crew> crews = Crew.getCrews(matchingInfo, crewNames);
        List<Pair> pairList = new ArrayList<>();

        while (crews.size() > 3) {
            pairList.add(generatePair(crews));
            crews.remove(0);
            crews.remove(0);
        }

        pairList.add(new Pair(crews));

        if (isRematchingInSameLevel(matchingResult, matchingInfo, pairList)) return generatePairList(matchingResult, matchingInfo);

        return pairList;
    }

    private Pair generatePair(List<Crew> crews) {
        List<Crew> matchedCrews = new ArrayList<>();
        matchedCrews.add(crews.get(0));
        matchedCrews.add(crews.get(1));

        return new Pair(matchedCrews);
    }

    private boolean isRematchingInSameLevel(MatchingResult matchingResult, MatchingInfo matchingInfo, List<Pair> newPairList) {
        Level level = matchingInfo.getMission().getLevel();

        return Arrays.stream(Mission.values())
                .filter(mission -> mission.getLevel() == level)
                .anyMatch(mission -> {
                    MatchingInfo newMatchingInfo = MatchingInfo.findByCourseAndMission(matchingInfo.getCourse(), mission);
                    Pairs originPairs = matchingResult.findByInfo(newMatchingInfo);
                    if (originPairs == null) return false;
                    List<Pair> originPairList = originPairs.getPairs();
                    return hasSameMatching(originPairList, newPairList);
                });
    }

    private boolean hasSameMatching(List<Pair> originPairList, List<Pair> newPairList) {
        return originPairList.stream()
                .anyMatch(pair -> newPairList.stream()
                        .anyMatch(newPair -> newPair.equals(pair)));
    }



}
