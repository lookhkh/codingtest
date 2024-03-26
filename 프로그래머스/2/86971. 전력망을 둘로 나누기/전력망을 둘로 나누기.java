import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<wires.length; i++){
            List<List<Integer>> graph = new ArrayList<>();
            for(int c = 0; c<=n; c++) graph.add(new ArrayList<>());
            for(int j=0; j<wires.length; j++){
                if(i == j) continue;
                int[] wire = wires[j];
                graph.get(wire[0]).add(wire[1]);
                graph.get(wire[1]).add(wire[0]);
                
            }
            
            boolean[] path = new boolean[n+1];
            int first = -1;
            int second = -1;
            for(int nn=1; nn<=n; nn++){
                if(path[nn]) continue;
                if(first == -1) first = dfs(nn, path, graph);
                else second = dfs(nn, path, graph);
            }
            
            answer = Math.min(answer, Math.abs(first - second));
            
        }
        return answer;
    }
    
    int dfs(int idx, boolean[] path, List<List<Integer>> graph){
        path[idx] = true;
        
        List<Integer> sub = graph.get(idx);
        int sum = 1;
        for(int next : sub){
            if(path[next]) continue;
            sum+=dfs(next, path, graph);
        }
        return sum;
        
    }
}