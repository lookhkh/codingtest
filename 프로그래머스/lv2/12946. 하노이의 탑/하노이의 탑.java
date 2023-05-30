import java.util.*;
class Solution {
    int idx = 0;
    List<int[]> result = new ArrayList<>();
    public List<int[]> solution(int n) {
        int[][] answer = {};
        dfs(n,0,2,1);
       
        
        
        return result;
    }
    public void dfs(int len, int from, int to, int other){
        if(len == 0) return;
        dfs(len-1,from,other, to);
        result.add(new int[]{from+1,to+1});
        dfs(len-1,other,to, from);
    }
}