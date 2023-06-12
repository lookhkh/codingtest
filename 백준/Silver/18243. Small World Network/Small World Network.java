import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		map = new int[n+1][n+1];
		
		for(int[] w : map) {
			Arrays.fill(w, 100_000_000);
		}
		
		for(int i=1; i<=n; i++) {
			map[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			map[to][from] = map[from][to] = 1;
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
				if(map[i][j] > 6) {
					System.out.println("Big World!");
					return;
				}
			}
		}
		
		System.out.println("Small World!");
		
	}
}
