package BinarySearch;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {7,1,4,8,8,23,44,47};
        int[] b = {5, 8, 1, 23, 1, 11, 13, 100, -1, 0};
        lookupIndexes(a, b);
        /*Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int[] a = new int[amount + 1];
        a[0] = amount;
        for (int i = 1; i <= amount; i++) {
            a[i] = scanner.nextInt();
        }
        int heh  = scanner.nextInt();
        int[] b = new int[heh + 1];
        b[0] = heh;
        for (int i = 1; i <= heh; i++) {
            b[i] = scanner.nextInt();
        }
        lookupIndexes(a, b);*/
    }

    private static void lookupIndexes(int[] a, int[] b) {
        for (int i = 1; i < b.length; i++) {
            System.out.println(binSearch(a, b[i]) + " is an index of " + b[i]);
        }
    }

    private static int binSearch(int[] a, int b) {
        int l = 1;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == b) {
                return m;
            } else if (a[m] > b) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
