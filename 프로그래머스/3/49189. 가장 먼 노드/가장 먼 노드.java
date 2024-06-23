import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        
        for(int[] ne : edge){
            
            int one = ne[0];
            int second = ne[1];
            
            graph.get(one).add(second);
            graph.get(second).add(one);
            
        }
        
        PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cnt, t2.cnt));
        que.add(new Edge(1, 0));
        
        int[] dis = new int[n+1];
        boolean[] his = new boolean[n+1];
        
        while(!que.isEmpty()){
            
            Edge next = que.poll();
            if(his[next.to]) continue;
            his[next.to] = true;
            dis[next.to] = next.cnt;
            
            List<Integer> sub = graph.get(next.to);
            
            for(int c : sub){
                
                if(his[c]) continue;
                que.add(new Edge(c, next.cnt+1));
                
            }
            
            
        }
        
        int max = Arrays.stream(dis).max().getAsInt();
        
        for(int next : dis){
            if(next == max) answer++;
        }
        
        
        
        return answer;
    }
}

class Edge{
    int cnt;
    int to;
    public Edge(int to, int cnt){
        this.cnt = cnt;
        this.to = to;
    }
}