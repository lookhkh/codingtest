/**
f[0] = 0;
f[1] = 1;
f[2] = f[0]+f[1]
f[n] = f[n-1] + f[n-2]
**/
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        
        for(int i=2; i<=n; i++){
            memo[i] = (memo[i-1]+memo[i-2]) % 1234567;
        }
        
        return memo[n];
    
        
    }
}