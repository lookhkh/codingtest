import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[][][] dp = new int[61][61][61];
	static int INF = Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		arr = new int[3];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		for(int[][] wp : dp) {
			for(int[] a : wp) {
				Arrays.fill(a, INF);
			}
		}
		
		dfs(arr[0],arr[1],arr[2],0);
		System.out.println(dp[0][0][0]);
	}

	private static void dfs(int a, int b, int c, int cnt) {
		
		
		a = Math.max(a, 0);
		b = Math.max(b, 0);
		c = Math.max(c, 0);
		
		if(dp[a][b][c] <= cnt) return;

		if(a == 0 && b == 0 && c == 0 ) {
//			System.out.println(cnt);
			dp[a][b][c] = Math.min(dp[a][b][c], cnt);
			return;
		}else {
			
			dp[a][b][c] = cnt;
			
			
			
				dfs(a-9,b-3,c-1,cnt+1);
				dfs(a-3,b-9,c-1,cnt+1);
				dfs(a-3,b-1,c-9,cnt+1);
				dfs(a-1,b-9,c-3,cnt+1);
				dfs(a-1,b-3,c-9,cnt+1);
				dfs(a-9,b-1,c-3,cnt+1);

		}
		
	}
}
