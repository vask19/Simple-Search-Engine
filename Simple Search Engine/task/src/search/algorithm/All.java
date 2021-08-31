package search.algorithm;

import java.util.*;

public class All implements InvertedIndex {

    @Override
    public List<Integer> start(List<String> date, List<String> dateForSearch) {
        Map<String ,List<Integer>> index = search(date);
        List<Integer> result = new ArrayList<>();
        for (String str:dateForSearch){

            if (index.containsKey(str.toLowerCase(Locale.ROOT)))
                result.addAll(index.get(str.toLowerCase(Locale.ROOT)));

        }

        return result;
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
















  /*  @Override
    public Map<String, List<Integer>> start(List<String> date) {
        Map<String ,List<Integer>> index = new HashMap<>();
        for (String s : date){
            List<Integer> in = new ArrayList<>();
            for (int j =0;j<date.size();j++){
                if (s.toLowerCase(Locale.ROOT)
                        .equals(date.get(j).toLowerCase(Locale.ROOT)))

                    in.add(j);
            }
            index.put(s.toLowerCase(Locale.ROOT),in);
        }
        return index;



}*/
