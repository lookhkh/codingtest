/*
    알파벳 소문자로 이루어진 문자열 s
    

*/
import java.util.*;
class Solution{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char next = s.charAt(i);
            if(stack.isEmpty()) stack.push(next);
            else{
                
                if(stack.peek() == next ) stack.pop();
                else{
                    stack.push(next);
                }
                
            }
            
        }
                
        return stack.size()==0?1:0;
    }
}