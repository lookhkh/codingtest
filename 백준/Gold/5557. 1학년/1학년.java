import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int n;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		arr = new int[n];
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		dp = new long[n][21];
		
		for(long[] w : dp) {
			Arrays.fill(w, -1);
		}
		
		long result = getDp(0,0);
		System.out.println(result);
		
	}
	private static long getDp(int idx, int sum) {
		
		if(sum > 20 || sum < 0) return 0;
		
		if(idx == n-1) {
			return sum == arr[arr.length-1]?1:0;
		}
		if(dp[idx][sum]!=-1) return dp[idx][sum];
		
		dp[idx][sum] = 0;

		if(idx == 0) return dp[idx][sum] = getDp(idx+1, sum+arr[idx]);
		return dp[idx][sum] = getDp(idx+1, sum+arr[idx])+getDp(idx+1, sum-arr[idx]);

		
	}
	

}
