import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		int n = Integer.valueOf( br.readLine() );
		
		int[] arr = new int[n+1];
		
		tk = new StringTokenizer(br.readLine()," ");
		
		for(int i=1; i<arr.length; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		
		int[] dp = new int[n+1];
		
		Arrays.fill(dp, 1);
		dp[0] = 0;

		for(int i=2; i<arr.length; i++) {
						
			for(int j=1; j<i; j++) {
				
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
				
			}
		}
		
		int r = Arrays.stream(dp).max().getAsInt();
		
		System.out.println(r);
		
	}
}