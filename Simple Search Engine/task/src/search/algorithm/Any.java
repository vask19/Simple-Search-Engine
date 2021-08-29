package search.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;

public class Any implements  InvertedIndex{
    @Override
    public Map<String, List<Integer>> start(List<String> date) {
            Map<String, List<Integer>> index = new HashMap<>();
            List<String > words = new ArrayList<>();

            date.forEach(s -> {
                List<String> wordsPerLine = Arrays.asList((s.split(" ")));
                words.addAll(wordsPerLine);
            });

            for (String word:words){
                List<Integer> IndexForWord = new ArrayList<>();
                for (int i =0;i<date.size();i++){
                    if (date.get(i).toLowerCase(Locale.ROOT)
                            .contains(word.toLowerCase(Locale.ROOT))){
                        IndexForWord.add(i);
                    }
                }
                index.put(word.toLowerCase(Locale.ROOT),IndexForWord);
            }
            return index;
        }
    }