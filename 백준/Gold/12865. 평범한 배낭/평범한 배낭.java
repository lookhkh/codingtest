import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		int[] ws = new int[n+1];
		int[] vs = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int w = Integer.valueOf(tk.nextToken());
			int v = Integer.valueOf(tk.nextToken());
			ws[i] = w;
			vs[i] = v;
		}
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<=m; j++) {
				if(j-ws[i] < 0) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-ws[i]]+vs[i]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}