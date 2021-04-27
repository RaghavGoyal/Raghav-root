package basics;

public class DecisionControl {
    public static void main(String[] args) {
        int input = 5;
        if(input % 2 == 0){
            System.out.println("Even number");
        }
        else System.out.println("Odd Number");

        switch(input){
            case 1: System.out.println("Selected 1");
                break;
            case 2: System.out.println("Selected 2");
                break;
            case 3: System.out.println("Selected 3");
                break;
            case 4: System.out.println("Selected 4");
                break;
            case 5: System.out.println("Selected 5");
                break;
            default: System.out.println("Selected wrong number");
        }


    }
}
