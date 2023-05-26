/*
    트리 형태의 네트워크를 두 개로 분할.
    이때 분할된 네트워크의 노드의 개수의 차이가 최소화
*/
import java.util.*;

class Solution {
    
    List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
    
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        
        
        for(int[] wire : wires){
            int s = wire[0];
            int t = wire[1];
            graph.get(s).add(t);
            graph.get(t).add(s);
        }
        
        int min = Integer.MAX_VALUE;

        for(int z = 0; z<wires.length; z++){
            int[] wire = wires[z];
            
            int w = wire[0];
            int x = wire[1];
            
            graph.get(w).remove((Integer)x);
            graph.get(x).remove((Integer)w);
                        
            boolean[] ch = new boolean[n+1];
            
            List<Integer> a = new ArrayList<>();
            
            for(int i=1; i<=n; i++){
                if(ch[i]) continue;
                
                ch[i] = true;
               
                int r = bfs(i,ch);
                a.add(r);
            }
            
            min = Math.min(min, a.stream().reduce(0,(t1,t2)->Math.abs(t1-t2)));
                        
            graph.get(w).add(x);
            graph.get(x).add(w);
        }
       
        
        return min;
    }
    
    public int bfs(int start, boolean[] ch){
        
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        int answer = 1;
        while(!que.isEmpty()){
            
            int next = que.poll();
            List<Integer> sub = graph.get(next);
            
            for(int n : sub){
                if(ch[n]) continue;
                ch[n] = true;
                que.add(n);
                answer++;
            }
        }
        
        return answer;
        
    }
}