import java.util.Arrays;
import java.util.*;
class Solution {
    
    int[][] arr;
    List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        arr = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
            
        for(int[] res : results){
            
            int winner = res[0];
            int loser = res[1];
            
            arr[loser][winner] = 1;
            arr[winner][loser] = -1;
            graph.get(loser).add(winner);
        }
        
    
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                   if(arr[i][k] == 1 && arr[k][j] == 1){
                       arr[i][j] = 1;
                       arr[j][i] = -1;
                   }
                    
                    if(arr[i][j] == -1 && arr[k][j] == -1){
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        
        
         
        for(int i=1; i<arr.length; i++){
            boolean result = true;
            
            for(int j=1; j<arr[i].length; j++){
                if(i!=j && arr[i][j] == 0){
                  result = false;  
                } 
            }
            
            if(result) {
                answer++;
            
            }
        }
        return answer;
    }

}