package GreatestCommonDivider;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gcd = gcd(scanner.nextInt(), scanner.nextInt());
        System.out.println(gcd);

    }
    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a >= b) {
            return gcd(a % b, b);
        }
        if (a <= b) {
            return gcd(a, b % a);

        }
        return 0;
    }
}
