import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> table = new HashMap<>();
        for(int i=0; i<want.length; i++){
            String name = want[i];
            int num = number[i];
            table.put(name, num);
        }
        
        Map<String,Integer> cur = new HashMap<>();
        
        int l = 0;
        int size = 1;
        cur.put(discount[l],1);
        for(int r=1; r<discount.length && l<=r; r++){
            
            String next = discount[r];
            cur.put(next, cur.getOrDefault(next,0)+1);
            size++;
            
            if(size > 10){
                String removedKey = discount[l++];
                cur.put(removedKey, cur.get(removedKey)-1);
                if(cur.get(removedKey) == 0) cur.remove(removedKey);
            }
       
            if(isSame(table, cur)) answer++;

        }
        
        return answer;
    }
    
    boolean isSame(Map<String,Integer> table, Map<String,Integer> cur){
        
        if(table.size() != cur.size()) return false;
        List<String> keys = new ArrayList<>(table.keySet());
        for(String key : keys){
            if(table.getOrDefault(key,0) != cur.getOrDefault(key,0)) return false;
        }
        return true;
    }
}