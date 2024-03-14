import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String b = convert(n);    
        return Integer.parseInt(b,3);
            }
    
    String convert(int n){
        StringBuilder b = new StringBuilder();
        while(n > 0){
            int remain = n%3;
            b.append(remain);
            n /= 3;
        }
        return b.toString();
    }
    
    
    
}