import java.time.LocalDate;

class Solution {
    public int dayOfYear(String date) {
        
        LocalDate d = LocalDate.parse(date);
        
        return d.getDayOfYear();
    }
}

Input
date =
"2019-01-09"
Output:
9
