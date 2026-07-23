import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestElement {
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

        // Input value of K
        System.out.print("Enter the value of K: ");
        int k = sc.nextInt();

        // Check if K is valid
        if (k <= 0 || k > n) {
            System.out.println("Invalid value of K!");
        } else {
            // Sort the array
            Arrays.sort(arr);

            // Print Kth smallest element
            System.out.println("The " + k + "th smallest element is: " + arr[k - 1]);
        }

        sc.close();
    }
}

Output :
Enter the size of the array: 5
Enter the array elements:
10
50
45
18
7
Enter the value of K: 2
The 2th smallest element is: 10
