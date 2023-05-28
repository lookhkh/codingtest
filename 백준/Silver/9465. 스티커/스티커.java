import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.valueOf(br.readLine());
		
		for(int i=0; i<w; i++) {
			
			int n = Integer.valueOf(br.readLine());
			int[][] arr = new int[2][n];
			
			for(int j=0; j<2; j++) {				
				StringTokenizer tk = new StringTokenizer(br.readLine()," ");
				for(int z=0; z<n; z++) {
					arr[j][z] = Integer.valueOf(tk.nextToken());
				}
			}
			
			/*
			 * 
			 * dp[n][k] => n번재 줄의 k번째 상태까지의 최대값.
			 * k = 0 위에서 가져옴
			 * k = 1 아래에서 가져옴
			 * k = 2 아무데서도 가져오지 않음.
			 * 
			 * dp[n][0] = Math.max( dp[n-1][1] , dp[n-1][2] ) + arr[n][0]
			 * dp[n][1] = Math.max( dp[n-1][0] , dp[n-1][2] ) + arr[n][1]
			 * dp[n][2] = Math.max( dp[n-1][1] , dp[n-1][0], dp[n-1][2] )
			 * 
			 * */
			
			int[][] dp = new int[n][3];
			
			dp[0][0] = arr[0][0];
			dp[0][1] = arr[1][0];
			dp[0][2] = 0;
			
			for(int x=1; x<n; x++) {
				
				dp[x][0] = Math.max(dp[x-1][1], dp[x-1][2])+arr[0][x];
				dp[x][1] = Math.max(dp[x-1][0], dp[x-1][2])+arr[1][x];
				dp[x][2] = Math.max(Math.max(dp[x-1][0], dp[x-1][1]),dp[x-1][2]);
				
			}
			
			int max = Integer.MIN_VALUE;
			for(int x=0; x<3; x++) {
				max = Math.max(max, dp[n-1][x]);
			}
			System.out.println(max);
			
		}
		
	}
}
