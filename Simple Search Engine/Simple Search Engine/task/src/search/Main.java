package search;

import search.algorithm.LinearSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.start(args[1]);
    }

}
