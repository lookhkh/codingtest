class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length+1][4+1];
        
        dp[1][1] = land[0][0];
        dp[1][2] = land[0][1];
        dp[1][3] = land[0][2];
        dp[1][4] = land[0][3];
        
        for(int i=2; i<=land.length; i++){
            
            for(int j=1; j<=4; j++){
                
                for(int z = 1; z<=4; z++){
                    if(j == z) continue;
                    dp[i][j] = Math.max(dp[i-1][z]+land[i-1][j-1],dp[i][j]);
                    
                }
                
            }
            
        }
        
        // for(int i=1; i<dp.length; i++){
        //     String t= "";
        //     for(int j=1; j<=4; j++){
        //         t+=dp[i][j]+" ";
        //     }
        //     System.out.println(t);
        // }
        
        int max = 0;
        for(int i=0; i<=4; i++){
            // System.out.println(dp[land.length][i]);
            max = Math.max(max,dp[land.length][i]);
        }
        
        return max;
    }
}