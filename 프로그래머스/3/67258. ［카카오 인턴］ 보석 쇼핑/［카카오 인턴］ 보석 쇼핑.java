/**
1. 전체 보석의 종류의 개수 확인 Set
2. 
**/
import java.util.*;
class Solution {

    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        
        Set<String> set = new HashSet<>(List.of(gems));
        
        Map<String,Integer> cur = new HashMap<>();
        
        int l = 0;
        cur.put(gems[l], 1);
        int min = Integer.MAX_VALUE;
        
        if(check(set, cur)){
                min = 0;
                answer[0] = 1;
                answer[1] = 1;
        }
        
        for(int r = 1; r<gems.length; r++){
            String next = gems[r];
            
            while(l < r){
                
                String left = gems[l];
                if(left.equals(next) || cur.get(left) > 1){
                    cur.put(left, cur.get(left)-1);
                    if(cur.get(left) == 0) cur.remove(left);
                    l++;
                }else break;
                
            }
            
            cur.put(next, cur.getOrDefault(next,0)+1);
            if(check(set, cur)){
                int res = r - l;
                if(res >= min) continue;
                min = res;
                answer[0] = l+1;
                answer[1] = r+1;
            }
            
        }
        
        
        return answer;
    }
    
    boolean check(Set<String> set, Map<String,Integer> cur){
      
        return cur.size()==set.size();
        
    }
    
}