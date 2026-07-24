import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> salaries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            salaries.add(sc.nextInt());
        }

        salaries.forEach(salary -> {
            int updatedSalary = (int)(salary * 1.10);
            System.out.print(updatedSalary + " ");
        });

        sc.close();
    }
}

Output :
3
20000
564545
1545425
22000 620999 1699967 
