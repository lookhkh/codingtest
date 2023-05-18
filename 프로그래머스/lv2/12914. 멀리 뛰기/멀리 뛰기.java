class Solution {
    long[] dp;
    public long solution(int n) {
        long answer = 0;
        dp = new long[n+1];
        int divide = 1234567;
        if(n <= 2) return n;
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]%1234567+dp[i-2]%1234567;
            dp[i]%=1234567;
        }
        
        
        
        return dp[n];
    }
}