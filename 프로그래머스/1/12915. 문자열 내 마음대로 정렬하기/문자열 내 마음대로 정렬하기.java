import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (t1,t2)->{
            char first = t1.charAt(n);
            char second = t2.charAt(n);
            if(first!=second) return Integer.compare((int)first, (int)second);
            return t1.compareTo(t2);
        });
        
        return strings;
    }
}