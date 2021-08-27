package search.algorithm;

import java.util.*;

public class InvertedIndex {


    static String [][] a = new String[5][5];



    public static void start(String arr[][]){
        Map<String ,List<Integer>> index = new HashMap<>();
        List<String > l = new ArrayList<>();
        for (int i =0;i<arr.length;i++){
            for (int j = 0;j<arr[i].length;j++){
                if (!index.containsKey(arr[i][j])){
                    index.put(arr[i][j], Collections.emptyList());
                }
                for (int z =0;z<arr[j].length;z++){
                    if (arr[i][j] == arr[j][z])
                        l.add(arr[i][j]);

                }

            }
        }
        System.out.println(l);



    }

}
