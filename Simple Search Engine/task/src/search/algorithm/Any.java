package search.algorithm;


import java.util.*;


public class Any implements  InvertedIndex{
    @Override
    public Map<String ,List<Integer>> start(List<String> date, List<String> dateForSearch) {
        Map<String ,List<Integer>> map = search(date);
        Map<String ,List<Integer>> index = new HashMap<>();
        for (String str:dateForSearch){
            if (map.containsKey(str.toLowerCase(Locale.ROOT)))
                index.put(str.toLowerCase(Locale.ROOT),map.get(str.toLowerCase(Locale.ROOT)));
        }

        return index;
    }
}
