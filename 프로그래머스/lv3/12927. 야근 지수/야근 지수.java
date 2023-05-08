import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>((t1,t2)->Integer.compare(t2,t1));
        
        for(int work : works){
            que.add(work);
        }
        
        for(int i=n; i>0; i--){
            
            int next = que.poll();
            next-= 1;
            que.add(next);
            
        }
        
        while(!que.isEmpty()){
            int next = que.poll();
            if(next>0) answer+= Math.pow(next,2);
        }
        
        return answer;
    }
}