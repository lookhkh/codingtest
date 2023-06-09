import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		long[] dp = new long[1_000_001];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		long mod = 1_000_000_009L;
		for(int i=3; i<dp.length; i++) {
			
			dp[i] = dp[i-1]%mod+dp[i-2]%mod+dp[i-3]%mod;
			dp[i] %= 1_000_000_009;
			
		}
		
		int t= 1;
		
		StringBuilder b= new StringBuilder();
		for(int i=0; i<n; i++) {
			
			int next = in.nextInt();
			b.append(dp[next]+"\n");
			
		}
		System.out.println(b.toString());
		
	}
}
