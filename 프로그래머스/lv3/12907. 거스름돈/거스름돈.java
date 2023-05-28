import java.util.Arrays;

class Solution {
    public int solution(int k, int[] money) {
        
            int n = money.length;
            int[] arr = money;
			Arrays.sort(arr);

			int[][] dp = new int[n+1][k+1];
			
			for(int i=0; i<n; i++) {
				int w = arr[i];
				if(w > k) continue;
				dp[i+1][w] = 1;
			}
	
			for(int i=1; i<=n; i++) {
				
				int next = arr[i-1];
				
				
				
				for(int j=1; j<=k; j++) {
					
					if(j < next) dp[i][j] += dp[i-1][j];
					else {
						dp[i][j] += dp[i-1][j]+dp[i][j-next];
					}
					
				}
			}
			
			return dp[n][k];
		}
}