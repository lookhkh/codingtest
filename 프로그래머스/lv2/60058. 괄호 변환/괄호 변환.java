/*
    '('와' ')' 개수가 동일한 문자열이 있을 경우, 이를 균형잡힌 괄호 문자열
    
    1. 빈 문자열일 경우, 빈문자열을 반환
*/
import java.util.Stack;
import java.lang.StringBuilder;
class Solution {
    public String solution(String p) {
        String answer = "";
        if(p.equals("")) return "";
        if(isValid(p)) return p;
        
        
        return dfs(p);
        
    }
    
    
    public String dfs(String next){
        
        if(next.equals("")) return "";
        int nextIdx = getIdx(next);
        
        String u = next.substring(0,nextIdx+1);
        String v = next.substring(nextIdx+1);
        
        System.out.println(nextIdx+" "+u+"  "+v);
        
        if(isValid(u)) return u+dfs(v);
        
        if(u.length() >= 4) {
            u = u.substring(1,u.length()-1);
            
            StringBuilder b= new StringBuilder();
            
            for(int i=0; i<u.length(); i++){
                char nextw = u.charAt(i);
                b.append(nextw==')'?'(':')');
            }
            
            u = b.toString();
            
            return "("+dfs(v)+")"+u;

        }else{
            return "("+dfs(v)+")";
        }
        
     
    }
    
    public int getIdx(String next){
        
        int left  =  0;
        int right = 0;
        
        for(int i=0; i<next.length(); i++){
            char n = next.charAt(i);
            
            if(n=='(') left++;
            else right++;
            
            if(left == right){
                return i;
            }
            
        }
        
        return -1;
        
    }
    
    public boolean isValid(String u){
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<u.length(); i++){
            
            char nextChar = u.charAt(i);
            
            if(stack.isEmpty()){
                if(nextChar == ')') return false;
                stack.push(nextChar);  
            } 
            else{
                
                if(stack.peek() ==')') return false;
                if(stack.peek()=='(' && nextChar ==')') stack.pop();
                else stack.push(nextChar);

            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}