import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> table = new HashMap<>();
        for(int next : topping){
            table.put(next, table.getOrDefault(next,0)+1);
        }
        
        Set<Integer> left = new HashSet<>();
        for(int i=0; i<topping.length; i++){
            
            int next = topping[i];
            left.add(next);
            table.put(next, table.getOrDefault(next,0)-1);
            if(table.get(next) <= 0) table.remove(next);
            
            if(left.size() == table.size()) answer++;
            
        }
        
        return answer;
    }
}