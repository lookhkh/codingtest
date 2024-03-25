/*
직간접적으로 모든 노드를 순회할 수 있다면, 그 노드의 순위를 확인할 수 있다.
**/
import java.util.*;
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<List<Integer>> win = new ArrayList<>();

    public int solution(int n, int[][] results) {
        int answer = 0;
        for(int i=0; i<n+1; i++) {
            list.add(new ArrayList<>());
            win.add(new ArrayList<>());
        }
        
        
        for(int[] result : results){
            
            int winner = result[0];
            int loser = result[1];
            
            list.get(loser).add(winner);
            win.get(winner).add(loser);
        }
        
        for(int i=1; i<=n; i++){
            
            boolean[] path = new boolean[n+1];
            dfs(i, path, list);
            dfs(i, path , win);
            int winners = check(i, path);
            if(winners == n-1) answer++;
        }

        
        return answer;
    }
    
    void dfs(int start, boolean[] path, List<List<Integer>> list){
        path[start] = true;
        List<Integer> lists = list.get(start);
        for(int i=0; i<lists.size(); i++){
            if(path[lists.get(i)]) continue;
            dfs(lists.get(i), path, list);
        }
        
        
    }
    
    int check(int start, boolean[] ch){
        int ans = 0;
        for(int i=1; i<ch.length; i++){
            if(start == i ) continue;
            if(ch[i]) ans++;
        }
        return ans;
    }
} 