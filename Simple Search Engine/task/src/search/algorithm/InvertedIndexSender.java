package search.algorithm;

import java.util.List;
import java.util.Map;

public class InvertedIndexSender {
    private InvertedIndex index;

    public void setIndex(InvertedIndex index) {
        this.index = index;
    }

    public Map<String , List<Integer>> start(List<String > date){
        return  index.start(date);
    }
}
