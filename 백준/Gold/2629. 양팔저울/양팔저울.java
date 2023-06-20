import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] nums;
	static int[] targets;
	static boolean[][] dp;
	static int n;
	static int m;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		nums = new int[n];
		
		for(int i=0; i<n; i++) {
			nums[i] = Integer.valueOf(tk.nextToken());
		}
		
		m = Integer.valueOf(br.readLine());
		tk = new StringTokenizer(br.readLine()," ");
		targets = new int[m];
		for(int i=0; i<m; i++) {
			targets[i] = Integer.valueOf(tk.nextToken());
		}
		max = 40001;
		int tar = 11;
		dp = new boolean[n+1][max+1];
		
		dfs(0,0);
	
		StringBuilder b= new StringBuilder();
		for(int i=0; i<targets.length; i++) {
			
			if(dp[n][targets[i]]) {
				b.append("Y ");
				continue;
			}
			b.append("N ");
			
		}
		
		System.out.println(b.toString().substring(0,b.length()-1));
		
	}
	private static void dfs(int idx, int w) {
		if(w > max) return;
		if(dp[idx][w]) return;
		dp[idx][w] = true;
		if(idx == n) return;
		dfs(idx+1, w+nums[idx]);
		dfs(idx+1, Math.abs(w-nums[idx]));
		dfs(idx+1, w);
		
		
	}
}
