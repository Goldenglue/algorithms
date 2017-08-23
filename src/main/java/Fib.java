import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a  = input.nextInt();
        int b = input.nextInt();
        int gcd = GCD.gcd(a,b);
        System.out.println(gcd);

    }

    private static int lastNumberOfFib(int n) {
        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) % 10;
            System.out.println(fibArray[i]);
        }
        return fibArray[n];
    }
    private static int fib(int n) {
        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            System.out.println(fibArray[i]);
        }
        return fibArray[n];
    }

}
