import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((t1,t2)->Integer.compare(t2.value, t1.value));
        Queue<Wrapper> que = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            Wrapper n = new Wrapper(i,priorities[i]);
            pq.add(n);
            que.add(n);
        }
        int cnt = 0;
        while(!que.isEmpty()){
                        
            Wrapper next = que.poll();
            if(pq.peek().value <= next.value){
                // System.out.println(next.idx+" "+next.value);
                pq.poll();
                cnt++;
                if(next.idx == location) return cnt;
            }else{
                que.add(next);
            }
            
            
        }
        
        int answer = 0;
        return answer;
    }
}

class Wrapper{
    int value;
    int idx;
    Wrapper(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}