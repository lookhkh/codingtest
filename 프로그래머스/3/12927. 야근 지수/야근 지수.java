import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> que = new PriorityQueue<>((t1,t2)->Long.compare(t2,t1));
        
        for(int work : works) que.add(Long.valueOf(work));
        
        while(n > 0 && que.peek()>0){
            
            long next = que.poll();
            
            next-=1;
            que.add(next);
            n--;
            
        }
        
        while(!que.isEmpty()) answer+=Math.pow(que.poll(),2);
                
        
        return answer;
    }
}
