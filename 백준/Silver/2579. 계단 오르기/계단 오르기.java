import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] stairs;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


		int nums = Integer.valueOf( br.readLine() );
		
		stairs = new int[nums+1];
		dp = new int[nums+1];
		
		for(int i=1; i<=nums; i++) {
			
			int num = Integer.valueOf( br.readLine() );
			stairs[i] = num;
		}
		
		int result = dp(nums);
		System.out.println(result);
		
	}

	private static int dp(int nums) {
		if(nums <= 0) return 0;
		if(dp[nums] != 0 )return dp[nums];
		
		if( nums == 1) return stairs[1];
		if ( nums == 2) return stairs[2]+stairs[1];
		
		return dp[nums] = Math.max(dp(nums-2), dp(nums-3)+stairs[nums-1])+stairs[nums];
	}


}