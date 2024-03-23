import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            String r = move(s, i);
            if(check(r)) answer++;
        }
        return answer;
    }
    
    boolean check(String s){
        Stack<Character> stacks = new Stack<>();
        for(char next : s.toCharArray()){
            if(stacks.isEmpty()) {stacks.add(next);}
            else if(isMatching(next, stacks.peek())) {stacks.pop();}
            else {stacks.push(next);}
        }
        return stacks.isEmpty();
    }
    

    
    boolean isMatching(char a, char b){
        char[][] chars = new char[][]{new char[]{'[',']'}, new char[]{'{','}'}, new char[]{'(',')'}};
        for(char[] next : chars){
            if( (next[1] == a && next[0] == b)) return true;
        }
        return false;
    }
    
    String move(String s, int n){
        
        char[] chars = new char[s.length()];
        for(int i=0; i<chars.length; i++){
            chars[i] = s.charAt(n);
            n = (n+1)%chars.length;
        }
        
        
        return new String(chars);
        
        
    }
}