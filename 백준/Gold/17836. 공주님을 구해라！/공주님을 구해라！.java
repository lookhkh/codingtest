import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int t;
	static int[][] arr;
	
	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};

	static int min = Integer.MAX_VALUE;
	
	static class Hero{
		
		int x;
		int y;
		boolean isGram;
		int cnt;
		
		public Hero(int x, int y, boolean isGram, int cnt) {

			this.x = x;
			this.y = y;
			this.isGram = isGram;
			this.cnt = cnt;
		}


		@Override
		public String toString() {
			return "Hero [x=" + x + ", y=" + y + ", isGram=" + isGram + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		t = Integer.valueOf(tk.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<m; j++) {
				
				arr[i][j] = Integer.valueOf(tk.nextToken());
				
			}			
		}
		
		bfs(0,0);
	
	}

	private static void bfs(int x, int y) {
		
		Queue<Hero> que = new LinkedList<>();
		boolean[][][] ch = new boolean[2][n][m];
		
		boolean isGram = arr[0][0] == 2;
		
		que.add(new Hero(x,y,isGram,0));
		
		while(!que.isEmpty()) {
			
			Hero hero = que.poll();
			
			if(hero.cnt> t) {
				System.out.println("Fail");
				return;
			};
			
			if(hero.x == n-1 && hero.y == m-1) {
				System.out.println(hero.cnt);
				return;
			}
			
			if(ch[hero.isGram? 0 : 1][hero.x][hero.y]) continue;
			
			ch[hero.isGram?0:1][hero.x][hero.y] = true;
			
			if(arr[hero.x][hero.y] == 2) hero.isGram = true;
			
			
			for(int i=0; i<4; i++) {
				
				int nextX = hero.x+dirX[i];
				int nextY = hero.y+dirY[i];
				
				if(!(nextX>=0 && nextY>=0 && nextX<n && nextY < m)) continue;
				
				if(hero.isGram) {
					if(ch[0][nextX][nextY]) continue;
					que.add(new Hero(nextX,nextY,true,hero.cnt+1));
				}else {
					if(ch[1][nextX][nextY]) continue;
					if(arr[nextX][nextY] == 1) continue;
					que.add(new Hero(nextX,nextY,false,hero.cnt+1));

				}

				
				
			}
			
			
		}
		
		System.out.println("Fail");
		
	}

	


	
	
}
