package pairmatching.domain.enums;

import java.util.Arrays;

public enum MatchingInfo {
    BACKEND_RACING_CAR(Course.BACKEND, Mission.RACING_CAR),
    BACKEND_LOTTO(Course.BACKEND, Mission.LOTTO),
    BACKEND_NUMBER_BASEBALL(Course.BACKEND, Mission.NUMBER_BASEBALL),
    BACKEND_SHOPPING_CART(Course.BACKEND, Mission.SHOPPING_CART),
    BACKEND_PAYMENT(Course.BACKEND, Mission.PAYMENT),
    BACKEND_SUBWAY_MAP(Course.BACKEND, Mission.SUBWAY_MAP),
    BACKEND_PERFORMANCE_IMPROVEMENT(Course.BACKEND, Mission.PERFORMANCE_IMPROVEMENT),
    BACKEND_RELEASE(Course.BACKEND, Mission.RELEASE),

    FRONTEND_RACING_CAR(Course.FRONTEND, Mission.RACING_CAR),
    FRONTEND_LOTTO(Course.FRONTEND, Mission.LOTTO),
    FRONTEND_NUMBER_BASEBALL(Course.FRONTEND, Mission.NUMBER_BASEBALL),
    FRONTEND_SHOPPING_CART(Course.FRONTEND, Mission.SHOPPING_CART),
    FRONTEND_PAYMENT(Course.FRONTEND, Mission.PAYMENT),
    FRONTEND_SUBWAY_MAP(Course.FRONTEND, Mission.SUBWAY_MAP),
    FRONTEND_PERFORMANCE_IMPROVEMENT(Course.FRONTEND, Mission.PERFORMANCE_IMPROVEMENT),
    FRONTEND_RELEASE(Course.FRONTEND, Mission.RELEASE);

    private final Course course;
    private final Mission mission;

    MatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }

    public static MatchingInfo findByCourseAndMission(Course course, Mission mission) {
        return Arrays.stream(MatchingInfo.values())
                .filter(matchingInfo -> matchingInfo.getCourse() == course)
                .filter(matchingInfo -> matchingInfo.getMission() == mission)
                .findAny().get();
    }
}
