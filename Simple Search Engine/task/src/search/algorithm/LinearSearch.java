package search.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LinearSearch {



    public static List<Integer> search(List<String > arr, String searchForSearch){
        List<Integer> index = new ArrayList<>();
        for (int i =0;i< arr.size();i++) {
            String temp = arr.get(i).toLowerCase(Locale.ROOT);
            if (temp.contains(searchForSearch.toLowerCase(Locale.ROOT))) {
                index.add(i);
            }
        }
        return index;
    }

}
