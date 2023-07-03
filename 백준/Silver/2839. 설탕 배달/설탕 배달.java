import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	/*
	 * 3kg / 5kg
	 * */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] dp = new int[5002];
		
		Arrays.fill(dp, 100_000);
		dp[3] = 1;
		dp[5] = 1;
		
		for(int i=6; i<=n; i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		
		System.out.println(dp[n]>=100_000?-1:dp[n]);
		
	}
}
