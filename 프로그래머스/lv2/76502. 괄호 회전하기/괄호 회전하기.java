/*
    괄호 회전하기
    [],(),{} 올바른 괄호.
    왼쪽으로 몇 칸 이동해야 올바른 괄호?
    
    1. 괄호를 어떻게 움직여도 올바른 괄호가 안 될 수 있다.
    ex) }}}
    2. 이미 올바른 괄호이며, 왼쪽으로 x칸 이동 시, 올바른 괄호가 될 수 있는 경우가 있다.
    ex()[]{}
    3. 최대 s길이만큼 이동 가능.
*/
import java.lang.StringBuilder;
import java.util.*;

class Solution {
    char[] chars;
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        
        chars = s.toCharArray();
        
        int n = 0;
        while(n < length){
            
            String next =  nextChar(n++);
            if(isValidOne(next)) answer++;
        }
        
        return answer;
    }
    
    public String nextChar(int shift){
        StringBuilder w = new StringBuilder();
        
        while(w.length() < chars.length){
            
            w.append(chars[shift++]);
            if(shift == chars.length) shift = 0;
            
            
        }    
        return w.toString();
    }
    
    public boolean isValidOne(String n){
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<n.length(); i++){
            
            char nextOne = n.charAt(i);
            
            if(stack.isEmpty()) stack.push(nextOne);
            else{
                
                if(isCoupled(stack.peek(),nextOne)) stack.pop();       
                else{
                    stack.push(nextOne);
                }
                
            }
            
        }
        
        return stack.size()==0?true:false;
        
    }
    
    public boolean isCoupled(char a , char b){
        if(b ==')' && a=='(') return true;
        if(b ==']' && a=='[') return true;
        if(b =='}' && a=='{') return true;
        return false;
    }
}