package search;

import search.algorithm.LinearSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    List<String > peoples;

    public void start(String path){
        peoples = fillingInDate(path);
        String answer = "-";
        do {
            System.out.println("\n=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            answer = sc.nextLine();

            switch (answer){
                case "1":
                    findPerson(peoples);
                    break;
                case "2":
                    printPerson();
                    break;
                case "0":
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        }while (!answer.equals("0"));
    }


    private void printPerson(){
        peoples.forEach(System.out::println);


    }
    private void printPerson(List<Integer> index){
        if (index.size() > 0){
            System.out.println("Found people:");
            index.forEach(in ->{
                System.out.println(peoples.get(in));
            });
        }

    }

    private void findPerson(List<String > people){
        System.out.println("Enter data to search people:");
        String searchDate = sc.next();

        List<Integer> index = LinearSearch.search(people,searchDate);
        if (index.size() > 0){
            printPerson(index);
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
