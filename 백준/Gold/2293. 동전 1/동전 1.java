import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int k = Integer.valueOf(tk.nextToken());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		
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
		
		System.out.println(dp[n][k]);
	}
}
