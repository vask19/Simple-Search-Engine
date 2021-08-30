package search.algorithm;

import java.util.List;
import java.util.Map;

public class None implements InvertedIndex{

    @Override
    public Map<String ,List<Integer>> start(List<String> date, List<String> dateForSearch) {
        return null;
    }
}
