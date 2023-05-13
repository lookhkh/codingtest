import java.util.*;

class Solution {
    List<Character> skips;
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        skips = new ArrayList<>();
        
        for(char t : skip.toCharArray()){
            skips.add(t);
        }
    
        for(char n : s.toCharArray()){
            char nextChar = convert(n,index);
            answer+=nextChar;
        }
        
            
        
        return answer;
    }
    
    public char convert(char n, int idx){
        
        while(idx > 0){
        
            n += 1;
            
            if(n > 'z'){
                n = 'a';
            }
            
            idx--;
            
            
            if(skips.contains(n)){
                idx++;
            }
        }
        
        return n;
        
    }
}