import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	static int[] dp;
public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.valueOf(br.readLine());
		
		//dp[i] => 남은 값이 i일 때 개수.
		
		
		
		for(int i=0; i<test; i++) {
			
			int num = Integer.valueOf(br.readLine());
			dp = new int[11];

			int result = getDp(num, 0);
			System.out.println(result);
			
		}

	
	}
private static int getDp(int num, int remain) {
	
	if(remain == num) return 1;
	if(remain >= num) return 0;
	if(dp[remain] != 0) return dp[remain];
	
	for(int i=1; i<=3; i++) {
		
		dp[remain] += getDp(num, remain+i);
		
	}
	
	
	return dp[remain];
}
}