import java.util.*;
class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder answer = new StringBuilder();
        
        for(char next : my_string.toCharArray()){
            if(set.add(next)) answer.append(next);
        }
        
        return answer.toString();
    }
}