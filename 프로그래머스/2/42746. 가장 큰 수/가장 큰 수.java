import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers)
            .mapToObj(num -> String.valueOf(num))
            .sorted((t1,t2)->{
                String first = t1+t2;
                String second = t2+t1;
                
                return Integer.valueOf(second) - Integer.valueOf(first);                
            }).toArray(String[]::new);
        
        
        StringBuilder answer = new StringBuilder();
        for(String next : arr){
            answer.append(next);
        }
        
        String ans = answer.toString();
        while(ans.startsWith("0") && ans.length()>1){
            ans = ans.substring(1, ans.length());
        }
        
        return ans;
    }
}