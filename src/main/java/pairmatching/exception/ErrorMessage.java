package pairmatching.exception;

public enum ErrorMessage {
    INVALID_MENU_INPUT("선택할 수 없는 기능입니다."),
    INVALID_FILE_CONTENT("잘못된 파일 형식입니다."),
    INVALID_INPUT("잘못된 입력 방식입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
