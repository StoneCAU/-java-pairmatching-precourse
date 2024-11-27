package pairmatching.domain.enums;

import java.util.Arrays;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course findByCourseName(String name) {
        return Arrays.stream(Course.values())
                .filter(c -> c.getName().equals(name))
                .findFirst().orElseThrow(() -> new PairMatchingException(ErrorMessage.INVALID_COURSE));
    }
}
