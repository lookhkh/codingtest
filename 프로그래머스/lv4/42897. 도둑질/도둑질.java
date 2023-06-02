/*
    첫 번째를 선택하는 경우 / 
    첫 번째를 선택하지 않는 경우.
    dp[0][k] = 첫 번째를 선택했을 때, k까지의 최대값.
    dp[1][k] = 첫 번째를 선택하지 않았을 때, k까지의 최대값.
      
      1 2 3 4 
    0 1 2 4 4
    1 0 2 3 3
    
*/
class Solution {
    int[][] dp;
    public int solution(int[] money) {
        int answer = 0;
        dp = new int[2][money.length+1];
        
        dp[0][1] = money[0];
        dp[1][0] = 0;
        
        for(int i=2; i<dp[0].length; i++){
            
            if(i!=dp[0].length-1) dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+money[i-1]);
            if(i==dp[0].length-1) dp[0][i] = dp[0][i-1];
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+money[i-1]);
            
        }
        
//             String t ="";
//             String t1="";
//             for(int j=0; j<dp[0].length; j++){
//                 t+=dp[0][j]+" ";
//                 t1+=dp[1][j]+" ";
//             }
        
//             System.out.println(t);
//             System.out.println(t1);
        
        
        
        return Math.max(dp[0][money.length],dp[1][money.length]);
    }
}