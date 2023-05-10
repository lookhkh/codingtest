import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		int[] dp = new int[n];
		int max = 0;
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			
			for(int j=0; j<i; j++) {
				
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
					max = Math.max(dp[i], max);
				}

			}
			
		}
		
		
		System.out.println(n-max);
		
		
	}
}