package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.enums.Course;

public class Crew {
    private Course course;
    private String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public static List<Crew> getCrews(MatchingInfo matchingInfo, List<String> crewNames) {
        crewNames = suffleList(crewNames);

        return crewNames.stream()
                .map(crewName -> new Crew(matchingInfo.getCourse(), crewName))
                .collect(Collectors.toList());
    }

    private static List<String> suffleList(List<String> crewNames) {
        return Randoms.shuffle(crewNames);
    }
}
