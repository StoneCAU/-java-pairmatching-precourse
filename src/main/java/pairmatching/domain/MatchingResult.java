package pairmatching.domain;

import java.util.HashMap;
import java.util.Map;
import pairmatching.domain.enums.MatchingInfo;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.PairMatchingException;

public class MatchingResult {
    private static final Map<MatchingInfo, Pairs> resultMap = new HashMap<MatchingInfo, Pairs>();

    public Map<MatchingInfo, Pairs> getResultMap() {
        return resultMap;
    }

    public boolean hasResult(MatchingInfo info) {
        return resultMap.containsKey(info);
    }

    public void save(MatchingInfo info, Pairs pairs) {
        resultMap.put(info, pairs);
    }

    public Pairs findByInfo(MatchingInfo info) {
        Pairs pairs = resultMap.get(info);

        if (pairs == null) {
            throw new PairMatchingException(ErrorMessage.NOT_FOUND_RESULT);
        }
        return pairs;
    }
}
