package pairmatching.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;

public class CrewLoader {
    private final static String BACKEND_CREW_FILE_NAME = "backend-crew.md";
    private final static String FRONTEND_CREW_FILE_NAME = "frontend-crew.md";

    public static List<String> loadBackendCrew() {
        return loadMarkdownFile(BACKEND_CREW_FILE_NAME);
    }

    public static List<String> loadFrontendCrew() {
        return loadMarkdownFile(FRONTEND_CREW_FILE_NAME);
    }

    private static List<String> loadMarkdownFile(String fileName) {
        try (InputStream inputStream = CrewLoader.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            return reader.lines().collect(Collectors.toList());

        } catch (IOException e) {
            throw new PairMatchingException(ErrorMessage.INVALID_FILE_CONTENT);
        }
    }
}
