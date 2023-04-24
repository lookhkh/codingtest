import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp;
	static int n;
	
	static int max = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		n = Integer.valueOf( br.readLine() );
		dp = new int[1_000_001];
		Arrays.fill(dp, max);
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<=n; i++) {

			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3]+1);
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2]+1);
			dp[i] = Math.min(dp[i], dp[i-1]+1);
			
		
		}
		
		System.out.println(dp[n]);
		
		

		
	}

}
