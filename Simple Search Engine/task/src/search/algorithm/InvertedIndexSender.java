package search.algorithm;


import java.util.List;

public class InvertedIndexSender {
    private InvertedIndex index;


    public void setIndex(InvertedIndex index) {
        this.index = index;
    }

    public List<Integer> start(List<String> date, List<String> dateForSearch){
        return index.start(date,dateForSearch);
    }
}



