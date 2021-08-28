package search;

import search.algorithm.InvertedIndex;
import search.algorithm.LinearSearch;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    List<String > peoples;



    public void start(String path){
        Map<String ,List<Integer>> index = InvertedIndex.sr(
                fillingInDate(path)
        );
        peoples = fillingInDate(path);
        String answer = "-";

        do {
            System.out.println("\n=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            answer = sc.next();
            System.out.println();


            switch (answer){
                case "1":
                    printPerson(findPerson(index));
                    break;
                case "2":
                    printPerson();
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }

        }while (true);
    }


    private void printPerson(){
        peoples.forEach(System.out::println);



    }
    private void printPerson(List<Integer> index){
        if (index != null){
            System.out.println("Found people:");
            index.forEach(in ->{
                System.out.println(peoples.get(in));
            });
        }
        else System.out.println("No matching people found.");

    }

    private  List<Integer> findPerson(Map<String ,List<Integer>> index){
        System.out.println("Enter a name or email to search all suitable people.");
        String searchDate = sc.next().toLowerCase(Locale.ROOT);


        if (index.containsKey(searchDate)){

            return index.get(searchDate);
        }
        return null;

    }


    private  List<String> fillingInDate(String path) {
        return readFile(path);

    }


    private List<String >  readFile(String path){
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
