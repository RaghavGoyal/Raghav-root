package basics;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        //outpuut to console:
        System.out.println("Hello and welcome to java");

        //input- using scanner class.

        int num = new Scanner(System.in).nextInt();
        String name = new Scanner(System.in).nextLine();
        double gpa = new Scanner(System.in).nextDouble();

        System.out.println(num);
        System.out.println(name);
        System.out.println(gpa);
    }
}
