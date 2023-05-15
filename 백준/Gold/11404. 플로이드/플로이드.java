import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 * dp[x][y] = min(dp[x][y], dp[x][k]+dp[k][y])
 * 
 * 
 * */
public class Main {
	static int inf = 300_000_000;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		map = new int[n+1][n+1];
		
		for(int i=1; i<map.length; i++) {
			for(int j=1; j<map[i].length; j++) {
				map[i][j] = inf	;
				if(i == j) map[i][j] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int start = Integer.valueOf(tk.nextToken());
			int end = Integer.valueOf(tk.nextToken());
			int cost = Integer.valueOf(tk.nextToken());
			
			if(map[start][end]> cost)map[start][end] = cost;
			
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j] == inf) map[i][j] = 0;
			}
		}	
		
		for(int i=1; i<=n; i++) {
			String t= "";
			for(int j=1; j<=n; j++) {
				t+=map[i][j]+" ";
			}
			System.out.println(t.substring(0,t.length()-1));
		}
		

	}
}