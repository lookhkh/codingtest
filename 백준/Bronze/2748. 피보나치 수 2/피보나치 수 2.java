import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static long[] dp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		int n = Integer.valueOf( br.readLine() );
		
		dp = new long[n+1];
		Arrays.fill(dp, -1);
		long result = pivo(n);
		System.out.println(result);
		
	}

	private static long pivo(int n) {
		if(dp[n] != -1) return dp[n];
		if(n == 1) return 1;
		if(n == 0) return 0;

		return dp[n] = pivo(n-1)+pivo(n-2);

	}
}
