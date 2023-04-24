import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{

	static int n;
	static int m;
	static int[][] arr;
	
	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};
	static int[][] dp;
 	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		arr = new int[n][m];
		dp = new int[n][m];
		
		for(int[] w : dp) {
			Arrays.fill(w, -1);
		}

		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.valueOf(tk.nextToken());
			}
		}
		
		long r = dfs(0,0);
		System.out.println(r);
	}

	private static long dfs(int x, int y) {

		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		if(x == n-1 && y == m-1) {
			return dp[x][y] = 1;
			
		}else {
			
			int curHeight = arr[x][y];
			
			dp[x][y] = 0;
			
			for(int i=0; i<4; i++) {
				
				int nextX = x+dirX[i];
				int nextY = y+dirY[i];
				
				if(nextX>=0 && nextX<n && nextY>=0 & nextY < m) {
					if(curHeight > arr[nextX][nextY]) {
						if(dp[nextX][nextY] == 0) continue;
						else if(dp[nextX][nextY] > 0) dp[x][y]+=dp[nextX][nextY];
						else dp[x][y]+=dfs(nextX,nextY);
						
					}
				}
				
				
			}
			
			return dp[x][y];

		}
		
		
	}
}