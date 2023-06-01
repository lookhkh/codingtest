import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		int target = Integer.valueOf(tk.nextToken());
		int n = Integer.valueOf(tk.nextToken());
		
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int w = Integer.valueOf(tk.nextToken());
			int m = Integer.valueOf(tk.nextToken());
			arr[i][0] = w;
			arr[i][1] = m;
		}
		
		int[] dp = new int[10_000_000];
		
		for(int i=1; i<=10_00_000; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i < arr[j][0]) continue;
				dp[i] = Math.max(dp[i], dp[i-arr[j][0]]+arr[j][1]);
				if(dp[i] >=target) {
					System.out.println(i);
					return;
				}
			}
			
		}		
	}
}