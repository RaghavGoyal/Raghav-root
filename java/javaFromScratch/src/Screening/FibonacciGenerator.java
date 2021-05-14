package Screening;

import java.math.BigInteger;

public class FibonacciGenerator {
    /**
     * Requirements:
     * 1. Calculate for the 100th place i.e F(100)
     * 2. Using recursion
     */

    static BigInteger n1 = BigInteger.ZERO;
    static BigInteger n2 = BigInteger.ONE;
    static BigInteger n = BigInteger.ZERO;

    public static void main(String[] args) {
        BigInteger answer = generateFibonacci(100);
        System.out.println("100th place Fibonacci number is: " + answer);
    }

    private static BigInteger generateFibonacci(int end){
        switch(end){
            case 0:
                return n1;
            case 1:
                return n2;
            default:
                n = n1.add(n2);
                n1 = n2;
                n2 = n;
                generateFibonacci(end - 1);
        }
        return n ;
    }
}
