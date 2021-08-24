package search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        List<String > words
                = Arrays.asList(a.split(" "));
        if (words.contains(b)) {
            System.out.println(words.indexOf(b) + 1);
        }
        else System.out.println("Not found");



    }
}
