package challenges;

import java.util.Scanner;

public class MCQ {
    public static void main(String[] args) {
        String question = "What is the capital of India?";
        String option1 = "Delhi";
        String option2 = "Mumbai";
        String option3 = "Lucknow";
        String correctAns = option1;

        System.out.println(question);
        System.out.println("Options are: ");
        System.out.println("press a for: "+option1);
        System.out.println("press b for: "+option2);
        System.out.println("press c for: "+option3);

        String choice = new Scanner(System.in).next();

        if(choice.equalsIgnoreCase("a"))
            System.out.println("Congratulations! You have selected the correct ans.");
        
        else
            System.out.println("Oh no, Wrong ans.");
    }
}
