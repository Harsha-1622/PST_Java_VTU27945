import java.util.Scanner;

public class ArrayPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print all possible pairs
        System.out.println("All possible pairs are:");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }

        sc.close();
    }
}

Output :
Enter the size of the array: 5
Enter the array elements:
15
89
78
65
25
All possible pairs are:
(15, 89)
(15, 78)
(15, 65)
(15, 25)
(89, 78)
(89, 65)
(89, 25)
(78, 65)
(78, 25)
(65, 25)
