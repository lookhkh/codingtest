import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] stairs;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


		int nums = Integer.valueOf( br.readLine() );
		
		stairs = new int[nums+1];
		
		for(int i=1; i<=nums; i++) {
			
			int num = Integer.valueOf( br.readLine() );
			stairs[i] = num;
		}
		
		int[] dp = new int[nums+1];
		
        if(nums <=1) {
            System.out.println(stairs[1]);
            return;
        }
        
        if(nums <=2){
            System.out.println(stairs[1]+stairs[2]);
            return;
        }
        
		dp[1] = stairs[1];
		
		dp[2] = dp[1]+stairs[2];
		
	
		
		for(int i=3; i<stairs.length; i++) {
			
			dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2])+stairs[i];

		}
		System.out.println(dp[nums]);
	}

}