package pairmatching.exception;

public class PairMatchingException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public PairMatchingException(ErrorMessage errorMessage) {
        super(PREFIX + errorMessage.getMessage());
    }
}
