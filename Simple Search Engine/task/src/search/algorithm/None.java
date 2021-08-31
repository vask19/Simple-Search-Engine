package search.algorithm;

import java.util.*;

public class None implements InvertedIndex {

    @Override
    public List<Integer> start(List<String> date, List<String> dateForSearch) {
        return null;
    }

    @Override
    public Map<String, List<Integer>> search(List<String> date) {
        Map<String, List<Integer>> index = new HashMap<>();
        for (String s : date) {
            List<Integer> in = new ArrayList<>();
            for (int j = 0; j < date.size(); j++) {
                if (s.toLowerCase(Locale.ROOT)
                        .equals(date.get(j).toLowerCase(Locale.ROOT)))

                    in.add(j);
            }
            index.put(s.toLowerCase(Locale.ROOT), in);
        }
        return index;
    }
}