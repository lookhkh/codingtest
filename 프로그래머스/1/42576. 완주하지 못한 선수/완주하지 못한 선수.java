import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(String next : completion){
            map.put(next, map.getOrDefault(next,0)+1);
        }
        
        for(String next : participant){
            
            if(map.containsKey(next)){
                int val = map.get(next)-1;
                if(val > 0) map.put(next, map.get(next)-1);
                else map.remove(next);
            }else return next;
            
        }
        
        
        
        
        return "";
    }
}