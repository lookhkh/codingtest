class Solution {
    public int solution(int s[]) {
        int answer = 0;
        
        int[][] dp = new int[2][s.length];
        dp[0][0] = 0;
        dp[1][0] = s[0];
        
        if(s.length == 1) return Math.max(dp[0][0], dp[1][0]);
        
        dp[0][1] = s[1];
        dp[1][1] = s[0];
        
        if(s.length == 2) return Math.max(dp[0][1], dp[1][1]);
        for(int i=2; i<s.length; i++){
            
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+s[i]);
            if(i != s.length-1) dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+s[i]);

        }
        
        
        return Math.max(dp[0][s.length-1], dp[1][s.length-2]);
    }
}