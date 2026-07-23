import java.util.Scanner;

public class Fib {

    interface Fibonacci {
        int find(int n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        Fibonacci fib = (num) -> {
            if (num == 0) return 0;
            if (num == 1) return 1;

            int a = 0, b = 1;

            for (int i = 2; i <= num; i++) {
                int c = a + b;
                a = b;
                b = c;
            }

            return b;
        };

        System.out.println("Nth Fibonacci Number: " + fib.find(n));

        sc.close();
    }

  Output :
  Enter n: 8
  Nth Fibonacci Number: 21
}
