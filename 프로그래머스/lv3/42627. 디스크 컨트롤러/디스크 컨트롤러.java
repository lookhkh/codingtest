import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Solution {
    
    Map<Integer, List<int[]>> map = new HashMap<>();

    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (t1,t2)->Integer.compare(t1[0],t2[0]));

        for(int[] job : jobs){
            if(map.containsKey(job[0])){
                map.get(job[0]).add(job);
            }else{
                List<int[]> l = new ArrayList<>();
                l.add(job);
                map.put(job[0],l);
            }
        }
        
        
        
        
        PriorityQueue<int[]> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1[1],t2[1]));
        
        int[] res = new int[jobs.length];
        
        int resIdx = 0;
                
        int lastTime = 0;
        
        int[] lastWork = null;
        
        for(int i=0; i<500_001; i++){
            
            if(map.containsKey(i)){
                
                List<int[]> list = map.get(i);
                que.addAll(list);
                
            }
            
          if(lastTime != 0){
              if(i < lastTime) continue;
          }
           
          if(!que.isEmpty()){
                
              lastWork = que.poll();
                            
              res[resIdx++] = i-lastWork[0] + lastWork[1];
              
              lastTime = i+lastWork[1];
              
              System.out.println(i+" "+lastTime);
          }
            
            
        }
       
        System.out.println();

        for(int w : res){
            System.out.println(w);
        }
        System.out.println();

        return Arrays.stream(res).sum() / res.length;
    }
}