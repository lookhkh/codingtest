import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.valueOf(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		arr= new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		/*
		 * 
		 * dp[k] = k개의 카드를 소지하고 있을 때 최대값.
		 * dp[k] = max(dp[k], dp[k-arr[i]](i<=k)]
		 * 
		 * */
		
		int[] dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<=i; j++) {
				
				dp[i] = Math.max(dp[i], dp[i-j]+arr[j]);
				
			}
			
		}
		
		System.out.println(dp[n]);
		int t = 1;
		
	}
	
}