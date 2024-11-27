package pairmatching.exception;

public enum ErrorMessage {
    INVALID_MENU_INPUT("선택할 수 없는 기능입니다."),
    INVALID_FILE_CONTENT("잘못된 파일 형식입니다."),
    INVALID_INPUT("잘못된 입력 방식입니다."),
    INVALID_COURSE("존재하지 않는 코스입니다."),
    INVALID_LEVEL("존재하지 않는 단계입니다."),
    INVALID_MISSION("해당 레벨에 존재하지 않는 미션입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
