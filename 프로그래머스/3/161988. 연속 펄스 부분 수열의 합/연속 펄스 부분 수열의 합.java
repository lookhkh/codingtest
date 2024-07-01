class Solution {
    public long solution(int[] sequence) {
        long[][] dp = new long[2][sequence.length+1];
        //[0] => 홀 수 번째 인덱스에 -1을 곱해준다
        //[1] => 짝 수 번째 인덱스에 -1을 곱해준다
        
        dp[0][1] = sequence[0] * -1;
        dp[1][1] = sequence[0];
        
        if(sequence.length == 1) return Math.max(dp[0][1], dp[1][1]);
        
        long answer = 0;
        
        for(int i=2; i<=sequence.length; i++){
            int next = sequence[i-1];
            if(i % 2 != 0) next *= -1; 
            dp[0][i] = Math.max(next,  dp[0][i-1]+next);
            answer = Math.max(answer, dp[0][i]);
        }
        
        
        for(int i=2; i<=sequence.length; i++){
            int next = sequence[i-1];
            if(i % 2 == 0) next *= -1; 
            dp[1][i] = Math.max(next,  dp[1][i-1]+next);
            answer = Math.max(answer, dp[1][i]);

        }
        
        
        return answer;
    }
}