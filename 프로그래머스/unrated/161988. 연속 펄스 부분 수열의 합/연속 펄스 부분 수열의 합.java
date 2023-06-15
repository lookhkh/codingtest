/*
    -2,3,6,1,-3,-1,-2,4 
    -2 3 9 10 -3 -1 -2 4
*/
class Solution {
    public long solution(int[] sequence) {

        long[][] dp = new long[2][sequence.length+1];
        //0 +부터 시작, 1 -부터 시작
        dp[0][1] = sequence[0];
        dp[1][1] = sequence[0] * -1;
        long max = Math.max(dp[0][1], dp[1][1]);      
        for(int i=2; i<dp[0].length; i++){
            int nextSeq =  i % 2==0? sequence[i-1] * -1 : sequence[i-1] ; 
            dp[0][i] = Math.max(dp[0][i-1] +nextSeq, nextSeq );
            dp[1][i] = Math.max(dp[1][i-1] +nextSeq * -1, nextSeq * -1);
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }
      

        return max;
    }
}