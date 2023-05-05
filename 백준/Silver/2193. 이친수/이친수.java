import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		long[][]dp = new long[n+1][2];
		
        if(n == 1) {
			System.out.println(1);
			return;
		}
		
		dp[1][1] = 1;
		dp[2][0] = 1;
		
		for(int i=3; i<=n; i++) {
			
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];

			
		}
		
		System.out.println(dp[n][0]+dp[n][1]);
		
		
	}
}