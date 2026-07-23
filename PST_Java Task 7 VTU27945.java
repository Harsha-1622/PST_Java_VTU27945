import java.util.Scanner;
import java.util.Arrays;

public class DigitSumLambda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        String number = sc.nextLine();

        // Choose option
        System.out.print("Enter 1 for Even Digit Sum or 2 for Odd Digit Sum: ");
        int option = sc.nextInt();

        int sum;

        if (option == 1) {
            sum = Arrays.stream(number.split(""))
                        .mapToInt(Integer::parseInt)
                        .filter(digit -> digit % 2 == 0)
                        .sum();

            System.out.println("Sum of even digits: " + sum);

        } else if (option == 2) {
            sum = Arrays.stream(number.split(""))
                        .mapToInt(Integer::parseInt)
                        .filter(digit -> digit % 2 != 0)
                        .sum();

            System.out.println("Sum of odd digits: " + sum);

        } else {
            System.out.println("Invalid option!");
        }

        sc.close();
    }
}

Output :
Enter a number: 520
Enter 1 for Even Digit Sum or 2 for Odd Digit Sum: 2
Sum of odd digits: 5
