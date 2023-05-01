import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		arr = new int[m+1][2];
		
		for(int i=1; i<=m; i++) {
			
			tk = new StringTokenizer(br.readLine());
			int take = Integer.valueOf(tk.nextToken());
			int val = Integer.valueOf(tk.nextToken());
			
			arr[i][0] = take;
			arr[i][1] = val;
			
		}
		
		dp = new int[m+1][n+1];
		
		for(int i=1; i<arr.length; i++) {
			
			for(int j=1; j<n+1; j++) {
				
				if( j >= arr[i][1])dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - arr[i][1]]+arr[i][0]);
				else dp[i][j] = dp[i-1][j];
				
			}
			
		}
		
		System.out.println(dp[m][n]);
		
	}
	
}