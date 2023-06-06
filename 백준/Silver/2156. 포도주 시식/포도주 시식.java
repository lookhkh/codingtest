import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = in.nextInt();
		}
		
		int[][] dp = new int[n+1][2];
		
		dp[1][0] = dp[1][1] = arr[1];
		
		for(int i=2; i<=n; i++) {
			
			dp[i][0] = Math.max(dp[i-1][1]+arr[i], dp[i-1][0]);
			dp[i][1] = Math.max( Math.max(dp[i-2][0], dp[i-2][1]) + arr[i], dp[i-1][1]);
			
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
		
	}
}
