package search;

import search.algorithm.LinearSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    List<String > peoples;



    public void start(){
        peoples = fillingInDate();
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


    private  List<String> fillingInDate() {
        System.out.println("Enter the number of people:");
        int numberOfPeople = sc.nextInt();
        List<String> people = new ArrayList<>();
        for (int i = 0; i < numberOfPeople+1; i++) {
            people.add(sc.nextLine());
        }
        return people;
    }
}
