import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer =1;
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] cloth : clothes){
            
            String name = cloth[0];
            String type = cloth[1];
            map.putIfAbsent(type, new HashSet<>());
            map.get(type).add(name);
            
        }
        
        List<String> keys = new ArrayList<>(map.keySet());
        for(String key : keys){
            answer *=  map.get(key).size()+1;   
        }
        
        return answer-1;
    }
}