package search;

import search.algorithm.*;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private InvertedIndexSender invertedIndexSender = new InvertedIndexSender();
    List<String > peoples;

    public void start(String path){
        peoples = fillingInDate(path);

        do {
            System.out.println("\n=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            String answer = sc.nextLine();

            switch (answer){
                case "1":
                    findPerson(peoples);

                    break;
                case "2":
                    printAllPersons();
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

    private void printAllPersons(){
        peoples.forEach(System.out::println);

    }
    private void findPerson(List<String > date){
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategy = sc.nextLine();
        switch (strategy){
            case "ALL":
                invertedIndexSender.setIndex(new All());
                break;
            case "ANY":
                invertedIndexSender.setIndex(new Any());
                break;
            case "NONE":
                invertedIndexSender.setIndex(new None());
                break;
        }
        System.out.println("\nEnter a name or email to search all suitable people.");
        String answer = sc.nextLine();
        List<String > dateForSearch = new ArrayList<>();
        dateForSearch.add(answer);

        Set<Integer> index  = new HashSet<>(invertedIndexSender.start(date,dateForSearch));

        if (index != null){
            System.out.println("\n" + index.size() + " persons found:");
            index.forEach(in ->{
                System.out.println(peoples.get(in));
            });
        }
        else System.out.println("No matching people found.");
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
