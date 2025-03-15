import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        List<String> possibles = new ArrayList<>();
        possibles.add("aya");
        possibles.add("ye");
        possibles.add("woo");
        possibles.add("ma");
        
        Map<String, Integer> map = Map.of(
            "a",3, 
            "y",2,
            "w",3,
            "m",2);
        
        for(String next : babbling){
            
            int removed = 0;
            for(String possible : possibles){
                
                if(next.contains(possible)){
                    removed+=possible.length();
                }
                
            }
            
            if(removed == next.length()) answer++;
        }
        
                
        return answer;
        
        
    }
}