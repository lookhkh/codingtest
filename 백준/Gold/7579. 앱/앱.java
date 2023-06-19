import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;	
	static int[] bytes;
	static int[] cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		bytes = new int[n+1];
		cost = new int[n+1];
		int sum = 0;
		
		tk = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			bytes[i] = Integer.valueOf(tk.nextToken());
		}
		tk = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=n; i++) {
			cost[i] = Integer.valueOf(tk.nextToken());
			sum+=cost[i];
		}
		
		dp = new int[n+1][sum+1];
		
		for(int i=1; i<dp.length; i++) {
			
			for(int j=0; j<dp[0].length; j++) {
				
				if(j - cost[i] < 0) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+bytes[i]);
				
			}
		}
		
		int t =1;
		for(int i=0; i<=sum; i++) {
			if(dp[n][i] >= m) {
				System.out.println(i);
				break;
			}
		}
	}
}