package search.algorithm;


import java.util.*;

public interface InvertedIndex {

    List<Integer> start(List<String > date,List<String > dateForSearch);

    Map<String ,List<Integer>>search(List<String > dateFromFile);




}
