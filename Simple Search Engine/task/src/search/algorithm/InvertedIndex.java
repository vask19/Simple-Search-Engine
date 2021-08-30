package search.algorithm;

import java.util.*;

public interface InvertedIndex {

    Map<String ,List<Integer>> start(List<String > date,List<String > dateForSearch);

    default Map<String ,List<Integer>>search(List<String > dateFromFile){
        Map<String, List<Integer>> index = new HashMap<>();
        List<String > words = new ArrayList<>();

        dateFromFile.forEach(s -> {
            List<String> wordsPerLine = Arrays.asList((s.split(" ")));
            words.addAll(wordsPerLine);
        });

        for (String word:words){
            List<Integer> IndexForWord = new ArrayList<>();
            for (int i =0;i<dateFromFile.size();i++){
                if (dateFromFile.get(i).toLowerCase(Locale.ROOT)
                        .contains(word.toLowerCase(Locale.ROOT))){
                    IndexForWord.add(i);
                }
            }
            index.put(word.toLowerCase(Locale.ROOT),IndexForWord);
        }
        return index;
    }

}
