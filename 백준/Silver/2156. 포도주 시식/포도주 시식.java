import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nums = in.nextInt();
		int[] arr = new int[nums+1];
		for(int i=1; i<=nums; i++) {
			arr[i] = in.nextInt();
		}
		
		int[][] dp = new int[nums+1][2];
		
		dp[1][0] = dp[1][1] = arr[1];
		
		for(int i=2; i<dp.length; i++) {
			
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1])+arr[i];
			
		}
		
		System.out.println(Math.max(dp[nums][0], dp[nums][1]));
		int t =1;
	}
}
