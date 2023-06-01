import java.util.Arrays;
class Solution {


    
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlgo = 0;
        int maxCop = 0;
        
        for(int[] p : problems){
            maxAlgo = Math.max(maxAlgo, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }
        
        int[][] dp = new int[150+1][150+1];

         for(int[] w : dp){
             Arrays.fill(w,Integer.MAX_VALUE);
         }
        
        alp = Math.min(alp, maxAlgo);
        cop = Math.min(cop, maxCop);
        
        dp[alp][cop] = 0;
        
        for(int i=alp; i<=maxAlgo; i++){
            for(int j=cop; j<=maxCop; j++){
                int tAlgo = Math.min(maxAlgo,i+1);
                int tCop = Math.min(maxCop,j+1);
                   
                dp[tAlgo][j] = Math.min(dp[tAlgo][j], dp[i][j]+1);
                dp[i][tCop] = Math.min(dp[i][tCop], dp[i][j]+1);

                for(int z = 0; z<problems.length; z++){
                    int[] p = problems[z];
                    if(p[0] > i || p[1] > j) continue;
                    
                    int maxTempAlgo = Math.min(maxAlgo,i+p[2]);
                    int maxTempCop = Math.min(maxCop,j+p[3]);
                        
                    dp[maxTempAlgo][maxTempCop] = Math.min(dp[i][j]+p[4], dp[maxTempAlgo][maxTempCop]);
                    
                    
                }
                
            }
        }
        
        return dp[maxAlgo][maxCop];
    }
    
  
}