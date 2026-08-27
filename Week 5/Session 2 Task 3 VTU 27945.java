import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {

        // -------------------------------
        // Maximum Subarray - Kadane's Algorithm
        // -------------------------------
        int currentSum = arr.get(0);
        int maxSubarray = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {

            currentSum = Math.max(
                arr.get(i),
                currentSum + arr.get(i)
            );

            maxSubarray = Math.max(maxSubarray, currentSum);
        }

        // -------------------------------
        // Maximum Subsequence
        // -------------------------------
        int maxSubsequence = 0;
        int largestElement = arr.get(0);

        for (int num : arr) {

            if (num > 0) {
                maxSubsequence += num;
            }

            // Keep track of the largest element
            largestElement = Math.max(largestElement, num);
        }

        // If all numbers are negative,
        // choose the largest (least negative) number.
        if (maxSubsequence == 0) {
            maxSubsequence = largestElement;
        }

        List<Integer> result = new ArrayList<>();

        result.add(maxSubarray);
        result.add(maxSubsequence);

        return result;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
            );

        int t = Integer.parseInt(
            bufferedReader.readLine().trim()
        );

        for (int tItr = 0; tItr < t; tItr++) {

            int n = Integer.parseInt(
                bufferedReader.readLine().trim()
            );

            String[] arrTemp = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                int arrItem = Integer.parseInt(arrTemp[i]);

                arr.add(arrItem);
            }

            List<Integer> result = Result.maxSubarray(arr);

            for (int i = 0; i < result.size(); i++) {

                bufferedWriter.write(
                    String.valueOf(result.get(i))
                );

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

Output:
2
4
1 2 3 4
6
2 -1 2 3 4 -5

10 10
10 11
