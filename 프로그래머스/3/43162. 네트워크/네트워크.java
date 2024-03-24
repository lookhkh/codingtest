class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] path = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(path[i]) continue;
            path[i] = true;
            dfs(i, computers, path);
            answer++;
        }
        
        return answer;
    }
    
    void dfs(int node, int[][] edges, boolean[] path){
       System.out.println("node "+node);
       for(int i=0; i<edges[node].length; i++){
           if(path[i]) continue;
           if(edges[node][i] == 0) continue;
           path[i] = true;
           dfs(i, edges, path);
       }
        
    }
}