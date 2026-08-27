import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {

        int count = 0;

        // Start from the second character
        for (int i = 1; i < s.length(); i++) {

            // If current character is same as previous,
            // one character must be deleted.
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
        }

        return count;
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

        int q = Integer.parseInt(
                bufferedReader.readLine().trim()
        );

        for (int qItr = 0; qItr < q; qItr++) {

            String s = bufferedReader.readLine();

            int result = Result.alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

Output:
5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB

3
4
0
0
4
