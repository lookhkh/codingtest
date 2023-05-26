class Solution
{
    public int solution(int [][]board){
        
        int[][] dp = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 1) dp[i][j] = 1;
            }
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                
                if(board[i][j] == 0) continue;
                dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                max = Math.max(max, dp[i][j]);
            }
            //System.out.println(t);
        }


        return max * max;
    }
}