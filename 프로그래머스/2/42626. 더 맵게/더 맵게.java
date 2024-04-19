import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> que = new PriorityQueue<>((t1,t2)->Long.compare(t1,t2));
        
        for(int next : scoville) que.add((long)next);
        if(K  == 0) return 0;
        int cnt = 0;
        if(que.peek() == K) return 0;
        while(que.size()>=2){
            long next = que.poll();
            long next2 = que.poll() * 2;
            
            long result = next + next2;
            que.add(result);  
            cnt += 1;
            if(que.peek() >= K) return cnt;

        }
                        
        return -1;
    }
}