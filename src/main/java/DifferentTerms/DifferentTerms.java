package DifferentTerms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentTerms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generateTerms(1);
    }

    private static void generateTerms(int n) {
        List<Integer> ks = new ArrayList<>();
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (n == 1) {
                ks.add(n);
                break;
            }
            if (total + i*2 + 1 > n) {
                ks.add(n - total);
                break;
            }
            ks.add(i);
            total += i;
        }
        System.out.println(ks.size());
        ks.forEach(System.out::println);
    }
}
