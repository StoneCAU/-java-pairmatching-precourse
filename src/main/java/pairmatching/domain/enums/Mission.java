package pairmatching.domain.enums;

public enum Mission {
    RACING_CAR(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    NUMBER_BASEBALL(Level.LEVEL1, "숫자야구게임"),

    SHOPPING_CART(Level.LEVEL2, "장바구니"),
    PAYMENT(Level.LEVEL2, "결제"),
    SUBWAY_MAP(Level.LEVEL2, "지하철노선도"),

    PERFORMANCE_IMPROVEMENT(Level.LEVEL4, "성능개선"),
    RELEASE(Level.LEVEL4, "배포");


    private final Level level;
    private final String missionName;

    Mission(Level level, String missionName) {
        this.level = level;
        this.missionName = missionName;
    }

    public String getMissionName() {
        return missionName;
    }

    public Level getLevel() {
        return level;
    }
}
