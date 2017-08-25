package Fibonacci;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FibSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fib(scanner.nextInt()));
    }

    private static List<Integer> fib(int n) {
        Integer[] fibArray = new Integer[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        return Arrays.asList(fibArray);
    }
}
