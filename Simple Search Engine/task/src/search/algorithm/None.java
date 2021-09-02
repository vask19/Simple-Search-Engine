package search.algorithm;

import java.util.*;

public class None implements InvertedIndex {

    @Override
    public List<Integer> start(List<String> date, List<String> dateForSearch) {
        Map<String ,List<Integer>> map = search(date);

        List<Integer> index = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (String str:dateForSearch){
            for (String word :str.split(" ")){
                if (map.containsKey(word.toLowerCase(Locale.ROOT))){
                    index.addAll(map.get(word.toLowerCase(Locale.ROOT)));
                }
            }
        }
        for (var entry:map.entrySet()){
            result.addAll(entry.getValue());
        }

        result.removeAll(index);
        return result;
    }

    @Override
    public Map<String, List<Integer>> search(List<String> dateFromFile) {
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