import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Arithmetic {
    
    int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Arithmetic {
    
}

public class Solution {
    
    public static void main(String []args) {
        
        // Create a new Adder object
        Adder a = new Adder();
        
        // Print the name of the superclass
        System.out.println(
            "My superclass is: " + 
            a.getClass().getSuperclass().getName()
        );
        
        // Print results
        System.out.print(
            a.add(10,32) + " " + 
            a.add(10,3) + " " + 
            a.add(10,10) + "\n"
        );
    }
}

Output :
My superclass is: Arithmetic
42 13 20
