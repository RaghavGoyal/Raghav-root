package Screening;

public class ProcessStringArg {
    /**
     * Requirements:
     * Reverse each word of the string and re-arrange the string following the order:
     * 0 1 2 3 4 5 6 7 -> 7 0 6 1 5 2 4 3
     * Example:
     * input : the big cat jumped over the lazy dog
     * output : god eht yzal gib eht tac revo depmuj
     */

    public static void main(String[] args) {
        /**
         * Assuming input in Command Line Arguments.
         */
        String reversedInput = "";
        String output = "";
        for(int i = 0; i < args.length && args[i] != null ; i++){
            reversedInput = reversedInput.trim() + " " + reverseWord(args[i]);
        }
        String [] reversedInputArray = reversedInput.split(" ");
        for(int i = 0, j = reversedInputArray.length - 1; i < j ; i++, j--){
            output = output.trim() + " "+ reversedInputArray[j] +" "+ reversedInputArray[i] ;
        }
        if(reversedInputArray.length % 2 != 0){
            output = output.trim() + " " + reversedInputArray[(reversedInputArray.length + 1) / 2 - 1];
        }
        System.out.println(output);
    }

    private static String reverseWord(String word){
        String reversedWord = "";
        for(int i = word.length() - 1; i >= 0 && word.charAt(i) != '\0'; i--){
            reversedWord = reversedWord + word.charAt(i);
        }
        return reversedWord;
    }
}
