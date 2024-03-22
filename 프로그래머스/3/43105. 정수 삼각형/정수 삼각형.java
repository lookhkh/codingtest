import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
    
        if(triangle.length == 1) return triangle[0][0];
        int[][] memo = new int[triangle.length][triangle.length];
        for(int i=0; i<memo.length; i++) Arrays.fill(memo[i],-1);
        
        memo[0][0] = triangle[0][0];
        memo[1][0] = triangle[1][0]+memo[0][0];
        memo[1][1] = triangle[1][1]+memo[0][0];
        
        for(int i=2; i<triangle.length; i++){
            for(int j=0; j<i+1; j++){
                if(j >0 && j <i+1) memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-1])+triangle[i][j];
                if(j == 0) memo[i][j] = memo[i-1][j]+triangle[i][j];
                if(j == i+1) memo[i][j] = memo[i-1][j-1]+triangle[i][j];
            }
            
        }
        
        int n = triangle.length;
        int answer = 0;

        for(int i=0; i<n; i++){
            answer = Math.max(memo[n-1][i], answer);
        }
        
        return answer;
    }
}