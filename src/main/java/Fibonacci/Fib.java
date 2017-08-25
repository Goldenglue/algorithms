package Fibonacci;

import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    }

    private static int lastNumberOfFib(int n) {
        Integer[] fibArray = new Integer[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) % 10;
        }
        return fibArray[n];
    }


}
