import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.valueOf(br.readLine());
		
		for(int w=0; w<k; w++) {
			
			int num = Integer.valueOf(br.readLine());
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int[] coins = new int[num+1];
			for(int i=1; i<=num; i++) {
				coins[i] = Integer.valueOf(tk.nextToken());
			}
			int target = Integer.valueOf(br.readLine());
			
			int[][] dp = new int[num+1][target+1];
			dp[0][0] = 1;
			for(int i=1; i<dp.length; i++) {
				dp[i][0] = 1;
				for(int j=0; j<=target; j++) {
					
					if(j-coins[i] < 0) {
						dp[i][j] = dp[i-1][j];
						continue;
					}
					
					dp[i][j] = dp[i-1][j]+ dp[i][j - coins[i]];
					
					
				}
				
			}
			System.out.println(dp[num][target]);
			int t =1;
		}
		
	}
}
