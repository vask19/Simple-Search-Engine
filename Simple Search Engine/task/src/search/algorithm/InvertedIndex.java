package search.algorithm;

import java.util.List;
import java.util.Map;

public interface InvertedIndex {

    Map<String , List<Integer>> start(List<String > date);
}
