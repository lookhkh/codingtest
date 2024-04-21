import java.util.*;
class Solution {
    List<List<Edge>> list = new ArrayList<>();
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        for(int i=0; i<N+1; i++) list.add(new ArrayList<>());
        
        for(int[] next : road){
            int start = next[0];
            int end = next[1];
            int w = next[2];
            
            list.get(start).add(new Edge(end,w));
            list.get(end).add(new Edge(start,w));
        }
        
        //1번 마을에서 각 마을의 최단거리를 구하라.
        
        List<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.weight, t2.weight));
        boolean[] his = new boolean[N+1];
        
        que.add(new Edge(1, 0));
        
        while(!que.isEmpty()){
            
            Edge next = que.poll();
            if(his[next.to]) continue;
            his[next.to] = true;
            if(next.weight <= K) ans.add(next.to);
            
            List<Edge> arr = list.get(next.to);
            for(Edge e : arr){
                
                que.add(new Edge(e.to, e.weight+next.weight));
                
            }
            
            
        }
        

        return ans.size();
    }
}

class Edge{
    int to;
    int weight;
    Edge(int to, int w){
        this.to = to;
        this.weight = w;
    }
}