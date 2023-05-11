import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		int[][] arr = new int[n+1][m+1];
		
		for(int i=0; i<n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<m; j++) {
				arr[i+1][j+1] = Integer.valueOf(tk.nextToken());
			}
		}
		
		int[][][] dp = new int[3][n+1][m+1];
		
		for(int[][] w : dp) {
			
			for(int[] p : w) {
				Arrays.fill(p, Integer.MAX_VALUE);
			}
		}
		
		for(int i=1; i<=m; i++) {
			dp[0][1][i] = dp[1][1][i] = dp[2][1][i] = arr[1][i];
		}
		
		for(int i=1; i<=m; i++) {
			
			if( i == 1) {
				dp[1][2][1] = dp[1][1][1]+arr[2][1]; 
				dp[2][2][1] = dp[1][1][2]+arr[2][1];
			}else if(i == m) {
				dp[0][2][m] = dp[1][1][m-1]+arr[2][m];
				dp[1][2][m] = dp[1][1][m]+arr[2][m];
			}else {
				
				dp[0][2][i] = dp[0][1][i-1]+arr[2][i];
				dp[1][2][i] = dp[0][1][i]+arr[2][i];
				dp[2][2][i] = dp[0][1][i+1]+arr[2][i];
			}
		}
		

		for(int i=2; i<=n; i++) {
			
			for(int j=1; j<=m; j++) {
				
				if(j == 1) {
					
					dp[1][i][1] = dp[2][i-1][1]+arr[i][j];
					dp[2][i][1] = Math.min(dp[0][i-1][2], dp[1][i-1][2])+arr[i][j];
					
				}
				if(j !=1 && j != m) {
					dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1])+arr[i][j];
					dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j])+arr[i][j];
					dp[2][i][j] = Math.min(dp[1][i-1][j+1], dp[0][i-1][j+1])+arr[i][j];
					
				}
				if(j == m) {
					
					dp[0][i][m] = Math.min(dp[1][i-1][m-1], dp[2][i-1][m-1])+arr[i][j];
					dp[1][i][m] = dp[0][i-1][m] + arr[i][j];
					
				}
			}
			
			
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {
			for(int j=1; j<=m; j++) {
				result = Math.min(result, dp[i][n][j]);

			}
		}
		
		System.out.println(result);
		
	}
}