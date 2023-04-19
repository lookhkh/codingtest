import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t1 = br.readLine();
		String t2 = br.readLine();
		
		int[][] dp = new int[t1.length()+1][t2.length()+1];
		int max = 0;
		
		for(int i=1; i<=t1.length(); i++) {
			for(int j=1; j<=t2.length(); j++) {
				
				if(t1.charAt(i-1) == t2.charAt(j-1)) {
					
					dp[i][j] = dp[i-1][j-1]+1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		System.out.println(max);
	}
}
