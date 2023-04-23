
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] set = {1,2,5,7};
	
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		int[] dp = new int[n+1];
		
		for(int i=0; i<dp.length; i++) {
			dp[i] = i;
		}
		
		for(int i=0; i<set.length; i++) {
			
			int next = set[i];
			
			for(int j=2; j<dp.length; j++) {
				
				if( j >= next)dp[j] = Math.min(dp[j], dp[j-next]+1); 
				
			}
			
		}
		
		System.out.println(dp[n]);
		
	}

}