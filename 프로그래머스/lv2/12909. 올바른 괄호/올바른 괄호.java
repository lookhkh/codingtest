/*
    Stack
    문자열의 처음부터 스택에 집어넣는다. 
    이때, 열린 문자일 경우엔 stack에 바로 집어넣고
    닫힌 문자의 경우, stack의 최상단이 열린 문자열일 경우 그대로 팝한다.
    이 과정을 반복하여 최종적으로 stack의 크기가 0이면 성공.

*/
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char next = s.charAt(i);
            if(next == '(') stack.push(next);
            else{
                if(stack.isEmpty() || stack.peek()==')') stack.push(next);
                else{
                    stack.pop();
                }
            }
        }
    
        return stack.size()==0?true:false;
    }
}