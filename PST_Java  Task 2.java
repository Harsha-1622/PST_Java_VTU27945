Program :
import java.util.Scanner;

public class ArrayIndexAccess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Create array
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input index
        System.out.print("Enter the index: ");
        int index = sc.nextInt();

        // Check if index is valid
        if (index >= 0 && index < n) {
            System.out.println("Element at index " + index + " is: " + arr[index]);
        } else {
            System.out.println("Invalid index!");
        }

        sc.close();
    }
}

Output :
Enter the size of the array: 5
Enter the array elements:
10
20
30
40
50
Enter the index: 3
Element at index 3 is: 40
