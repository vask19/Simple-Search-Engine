package search;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static Collection<Integer> pow2(Collection<Integer> numbers) {
        List<Integer> answer = new ArrayList<>();
        numbers.forEach(in -> answer.add(in*in));
        return numbers;
    }
    public static void main(String[] args) {


       /* UserInterface userInterface = new UserInterface();
        //userInterface.start(args[1]);
        userInterface.start("C:\\Users\\vask\\IdeaProjects\\Simple Search Engine\\Simple Search Engine\\task\\src\\search\\text.txt");
    }*/

    }

}
