import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static int[][] dir = new int[][] {{1,-1},{-1,-1},{-1,1},{1,1}};
	
	static int[][] map;
	static int n;
	static int m;
	static int max = Integer.MIN_VALUE;
	static boolean[][] ch;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		if( n<2 && m <2) {
			System.out.println(0);
			return;
		}
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.valueOf(tk.nextToken());
			}
		}
		
		
		ch = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				dfs(i,j, 0);
				
			}
		}
		
		System.out.println(max);
		
		
		
		
		
	}
	private static void dfs(int x, int y , int total) {
		if(x == n) {
			max = Math.max(total, max);
			return;
		}else if( y >=m ) {
			dfs(x+1, 0, total);
		}else {
			
			if(!ch[x][y]) {
				for(int i=0; i<4; i++) {
					
					int firstX = x+dir[i][0];
					int firstY = y;
					
					int secondX =x;
					int secondY = y+dir[i][1];
					
					if(firstX >=0 && firstX < n 
							&& firstY >=0 && firstY < m && secondX >=0 && secondX < n 
							&& secondY >=0 && secondY < m) {
						
						if(ch[firstX][firstY] || ch[secondX][secondY] ) continue;
	
						ch[x][y] = ch[firstX][firstY] = ch[secondX][secondY] = true;
						
						int sum = map[x][y] * 2 + map[firstX][firstY]+map[secondX][secondY];
						dfs(x,y+1, total+sum);
						
						ch[x][y] = ch[firstX][firstY] = ch[secondX][secondY] = false;
	
					}
					
					
				}
				
				
			}
			
			dfs(x,y+1,total);
			
		}
	}

}