//https://school.programmers.co.kr/learn/courses/30/lessons/76502#

import java.util.Deque;
import java.util.LinkedList;
class Solution {
    
    Deque<Character> stack;
    
    public int solution(String s) {
        int answer = 0;
        stack = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++){
            if(i == 0 && isRightStr(s)) answer++;
            else{
                 s = s.substring(1)+s.charAt(0);
                boolean result = isRightStr(s);
                if(result) answer++;
            }
      
        }
      
        
        return answer;
    }
    
    public boolean isRightStr(String str){
        
        for(int i=0; i<str.length(); i++){
            char next = str.charAt(i);
            
            if(stack.isEmpty()){
                if(!isRightOrder(next)) return false;
                else stack.push(next);
            }else{
                
                if(next == getOpposite(stack.peek())) stack.pop();
                else{
                    
                    if(!isRightOrder(next)) return false;
                    else stack.push(next);
                    
                }
                
                
            }
            
        }
        
        if(!stack.isEmpty()) return false;
        return true;
    }
    
    public char getOpposite(char target){
        
        if(target == ')') return '(';
        if(target == '(') return ')';
        
        if(target =='[') return ']';
        if(target ==']') return '[';
        
        if(target =='}') return '{';
        if(target =='{') return '}';
        
        return '-';
    }
    
    public boolean isRightOrder(char target){
        if(target == '(') return true;
        
        if(target =='[') return true;
        
        if(target =='{') return true;
        
        else return false;
    }
}