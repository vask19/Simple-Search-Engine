package search.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InvertedIndexSender {
    private InvertedIndex index;

    public static void main(String[] args) {
        InvertedIndexSender invertedIndexSender = new InvertedIndexSender();
        invertedIndexSender.setIndex(new All());

        List<String  > pk = readFile("C:\\Users\\vask\\IdeaProjects\\Simple Search Engine\\Simple Search Engine\\task\\src\\search\\text.txt");
        List<String > pl = Arrays.asList("Blossom Ambler","Wendolyn Mcphillips");
        System.out.println(invertedIndexSender.start(pk,pl));
    }

    public void setIndex(InvertedIndex index) {
        this.index = index;
    }

    public Map<String ,List<Integer>> start(List<String > date,List<String> dateForSearch){
        if (index instanceof All) return index.start(date,dateForSearch);
        else if (index instanceof  Any){
            List<String > newArray = new ArrayList<>();
            for (String str: dateForSearch){
                newArray.addAll(Arrays.asList(str.split(" ")));
            }
            return index.start(date,newArray);
        }
        return null;
    }

    private static List<String >  readFile(String path){
        List<String > peoples = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(path))) {
            while (sc.hasNext()){
                peoples.add(sc.nextLine());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return peoples;
    }
}
