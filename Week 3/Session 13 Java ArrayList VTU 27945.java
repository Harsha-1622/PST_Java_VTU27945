import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of lines
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Read each line
        for (int i = 0; i < n; i++) {

            int d = sc.nextInt();

            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                row.add(sc.nextInt());
            }

            list.add(row);
        }

        // Number of queries
        int q = sc.nextInt();

        // Process queries
        for (int i = 0; i < q; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            // x and y are 1-based
            if (x >= 1 && x <= list.size() &&
                y >= 1 && y <= list.get(x - 1).size()) {

                System.out.println(list.get(x - 1).get(y - 1));

            } else {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
    
