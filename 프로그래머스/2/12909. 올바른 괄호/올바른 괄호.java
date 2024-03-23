import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char next : s.toCharArray()){
            
            if(next == '(') stack.push(next);
            else {
                if(stack.isEmpty()) return false;
                if(stack.peek() ==')') return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}