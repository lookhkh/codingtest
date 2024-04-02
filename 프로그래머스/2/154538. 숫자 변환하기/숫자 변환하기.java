import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cnt, t2.cnt));
        boolean[] path= new boolean[y+1];
        que.add(new Edge(x, 0));
        
        while(!que.isEmpty()){
            
            Edge next = que.poll();
            if(next.cur >= path.length) continue;
            if(next.cur == y){
                return next.cnt;
            }
            
            if(path[next.cur]) continue;
            path[next.cur] = true;
            
            for(int i=0; i<3; i++){
                if(i == 0) que.add(new Edge(next.cur+n, next.cnt+1));
                if(i == 1) que.add(new Edge(next.cur * 2, next.cnt+1));
                if(i == 2) que.add(new Edge(next.cur * 3, next.cnt+1));
            }
            
        }
        
        
        return -1;
    }
}
class Edge{
    int cur;
    int cnt;
    Edge(int cur, int cnt){
        this.cur = cur;
        this.cnt = cnt;
    }
}