import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};
	
	
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		arr = new int[n][n];
		int max = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.valueOf(tk.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int result = 0;
		for(int i=0; i<max; i++) {
			int temp = 0;
			boolean[][] ch = new boolean[n][n];
			for(int x=0; x<n; x++) {
				for(int y= 0; y<n; y++) {
					if(ch[x][y]) continue;
					if(arr[x][y] <=i) continue;
					temp+= bfs(x,y,i, ch);
				}
			}
			
			result = Math.max(result, temp);

		}
		System.out.println(result);
		
	}
	private static int bfs(int x, int y, int len, boolean[][] ch) {

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		ch[x][y] = true;
		
		while(!que.isEmpty()) {
			
			int[] next = que.poll();
			
			for(int i=0; i<4; i++) {
				
				int nextX = next[0]+dirX[i];
				int nextY = next[1]+dirY[i];
				if(nextX>=0 && nextY >=0 && nextX<n && nextY < n) {
					
					if(ch[nextX][nextY]) continue;
					if(arr[nextX][nextY] <= len) continue;
					ch[nextX][nextY] = true;
					que.add(new int[] {nextX,nextY});
					
				}
				
			}
			
		}
		return 1;
	}
}
