/**
1. 전체 보석의 종류의 개수 확인 Set
2. 
**/
import java.util.*;
class Solution {
    int cnt = 0;
    public int[] solution(String[] gems) {
        int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        Set<String> set = new HashSet<>();
        for(String gem : gems) set.add(gem);
        
        Map<String,Integer> cur = new HashMap<>();
        
        
        int l = 0;
        cur.put(gems[l], 1);
        cnt++;
        int min = Integer.MAX_VALUE;
        
        if(check(set)){
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
                    if(cur.get(left) == 0) cnt--;
                    l++;
                }else break;
                
            }
            
            cur.put(next, cur.getOrDefault(next,0)+1);
            if(cur.get(next) == 1) cnt++;
            if(check(set)){
                int res = r - l;
                if(res >= min) continue;
                min = res;
                answer[0] = l+1;
                answer[1] = r+1;
            }
            
        }
        
        
        return answer;
    }
    
    boolean check(Set<String> set){
      
        return this.cnt==set.size();
        
    }
    
}