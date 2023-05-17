class Solution {
    int[] dp ;
    public int solution(int n) {
        int answer = 0;
        int divide = 1234567;
        if(n == 2) return 1;
        
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]%divide+dp[i-2]%divide;
            dp[i]%=divide;
        }
        
        return dp[n];
    }
}