import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> circularPalindromes(String s) {

        int n = s.length();

        // Double the string for circular substrings
        String str = s + s;

        // Build transformed string: #a#b#c#...
        int len = 2 * str.length() + 1;
        char[] t = new char[len];

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                t[i] = '#';
            } else {
                t[i] = str.charAt(i / 2);
            }
        }

        // Manacher's algorithm
        int[] radius = new int[len];

        int center = 0;
        int right = 0;

        for (int i = 0; i < len; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]);
            }

            while (i - radius[i] - 1 >= 0 &&
                   i + radius[i] + 1 < len &&
                   t[i - radius[i] - 1] ==
                   t[i + radius[i] + 1]) {

                radius[i]++;
            }

            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }
        }

        // Log table
        int[] log = new int[len + 1];

        for (int i = 2; i <= len; i++) {
            log[i] = log[i / 2] + 1;
        }

        // Sparse table for maximum radius
        int levels = log[len] + 1;
        int[][] sparse = new int[levels][len];

        for (int i = 0; i < len; i++) {
            sparse[0][i] = radius[i];
        }

        for (int k = 1; k < levels; k++) {

            int size = 1 << k;
            int half = size >> 1;

            for (int i = 0; i + size <= len; i++) {
                sparse[k][i] = Math.max(
                    sparse[k - 1][i],
                    sparse[k - 1][i + half]
                );
            }
        }

        List<Integer> result = new ArrayList<>();

        // Find answer for every rotation
        for (int start = 0; start < n; start++) {

            /*
             * Transformed coordinates of this rotation:
             *
             * [2*start ................ 2*start + 2*n]
             */
            int L = 2 * start;
            int R = 2 * start + 2 * n;

            int low = 1;
            int high = n;
            int answer = 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                /*
                 * A palindrome of length 'mid' must have
                 * its center at least 'mid' away from
                 * both boundaries.
                 */
                int left = L + mid;
                int rightBound = R - mid;

                if (left <= rightBound &&
                    queryMax(sparse, log, left, rightBound) >= mid) {

                    answer = mid;
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }
            }

            result.add(answer);
        }

        return result;
    }

    private static int queryMax(
            int[][] sparse,
            int[] log,
            int left,
            int right) {

        if (left > right) {
            return 0;
        }

        int length = right - left + 1;
        int k = log[length];

        return Math.max(
            sparse[k][left],
            sparse[k][right - (1 << k) + 1]
        );
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

Input :
13
aaaaabbbbaaaa
Output :
12
12
10
8
8
9
11
13
11
9
8
8
10
