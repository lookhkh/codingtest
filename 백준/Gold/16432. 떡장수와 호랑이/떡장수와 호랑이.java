import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static List<List<Integer>> list;
	static int[][] dp;
	static int[] path;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int num = Integer.valueOf(tk.nextToken());
			
			for(int j=0; j<num; j++) {
				list.get(i).add(Integer.valueOf(tk.nextToken()));
			}
		}
		
		
		
		dp = new int[n][11];
		
		
		for(int[] w : dp) {
			Arrays.fill(w, -1);
		}
		
		int result = dfs(0);
		
		if(result == 0) System.out.println(-1);
		else {
			for(int t : path) {
				System.out.println(t);
			}
		}
	}

	private static int dfs(int day) {

		List<Integer> sublist = list.get(day);
		
		for(int i=0; i<sublist.size(); i++) {
			
			int next = sublist.get(i);
			
			path = new int[n];
			
			path[day] = next;
			
			if(dp[day][next]!=-1 && dp[day][next] == 0) continue;
			
			dp[day][next] = dfs(day+1, next, path);
			

			if(dp[day][next] == 1) return 1;
		}
		
		return 0;
	}

	private static int dfs(int day, int previous, int[] path) {

		if(day == n) {
			return 1;
		}else {
			
			
			List<Integer> sub = list.get(day);
			
			for(int i=0; i<sub.size(); i++) {
				
				int next = sub.get(i);
				
				if(next == previous) {
					
					continue;
				}
				
				if(dp[day][next]!=-1 ) {
					
					if( dp[day][next] == 0 ) continue; ; 
				}

				
				path[day] = next;
				
				dp[day][next] = dfs(day+1, next, path);
				
				if(dp[day][next] == 1) return 1; 
			}
			
			return 0;
		}
		
		
	}
}
