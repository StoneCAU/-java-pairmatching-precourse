package pairmatching.domain.enums;

import java.util.Arrays;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Level findByLevelName(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.getName().equals(name))
                .findFirst().orElseThrow(() -> new PairMatchingException(ErrorMessage.INVALID_LEVEL));
    }

}
