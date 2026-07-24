import java.util.Scanner;

@FunctionalInterface
interface LastDigitSum {
    int add(int a, int b);
}

public class Main {

    public static int sumLastDigits(int a, int b) {
        return (a % 10) + (b % 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Method Reference
        LastDigitSum obj = Main::sumLastDigits;

        int result = obj.add(num1, num2);

        System.out.println("Sum of last digits = " + result);

        sc.close();
    }
}

Output :
Enter first number: 52
Enter second number: 31
Sum of last digits = 3
