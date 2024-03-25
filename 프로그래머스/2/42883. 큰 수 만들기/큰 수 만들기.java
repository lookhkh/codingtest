/**
완탐은 불가능. 1_000_000Cm
1911 911` 1
**/
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for(char next : number.toCharArray()){
            int ni = Integer.valueOf(next-'0');
            while(!stack.isEmpty() && stack.peek() < ni && cur < k) {
                stack.pop();
                cur++;
            }
            stack.push(ni);
        }

        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        
        String ans = answer.reverse().toString();
        if(ans.startsWith("0")) return "0";
        if(ans.length() > number.length() - k) return ans.substring(0,number.length()-k);
        return ans;
    }
}