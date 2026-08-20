import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> salaries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }

        salaries.stream()
                .map(salary -> salary + salary * 10 / 100)
                .forEach(salary -> System.out.print(salary + " "));

        sc.close();
    }
}

Output:
3
20000
564564
1234568
22000 621020 1358024 
