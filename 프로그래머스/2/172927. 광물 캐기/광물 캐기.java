import java.util.*;
class Solution {
    Map<Integer, Map<String, Integer>> map = Map.of(
        0, Map.of("diamond",1, "iron", 1, "stone",1),
        1, Map.of("diamond",5, "iron",1, "stone",1),
        2, Map.of("diamond",25, "iron",5, "stone",1)
    );
    
    int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] m) {
        int answer = 0;
        List<List<String>> list = new ArrayList<>();
        
        int idx = 0;
        while(idx < m.length){
            List<String> temp = new ArrayList<>();
            int cnt = 0;
            while(cnt < 5 && idx < m.length ){
                cnt++;
                temp.add(m[idx++]);
            }
            list.add(temp);
        }
        
        dfs(picks, list, 0, 0);
        
        return min;
    }
    
    void dfs(int[] picks, List<List<String>> list, int idx, int result){
        
        if((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || idx >= list.size()){
            min = Math.min(min, result);
        }else{
            
            
            for(int i=0; i<picks.length; i++){
                
                int next = picks[i];
                if(next == 0 ) continue;
                picks[i]-=1;
                int sum = 0;
                
                List<String> items = list.get(idx);
                
                for(String item : items){
                    sum+=map.get(i).get(item);
                }
                
                dfs(picks, list, idx+1, result+sum);
                picks[i]+=1;
            }
            
        }
        
    }
}