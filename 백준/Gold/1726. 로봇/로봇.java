import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[][] map;
	
	static class Robot{
		int x;
		int y;
		int dir;
		int cnt;
		List<Integer> commands;
		
		public Robot(int x, int y, int dir , int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
			this.commands = new ArrayList<>();
		
		}
		
		public Robot(int x, int y, int dir , int cnt, List<Integer> list) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
			this.commands = list;
		
		}
		



		@Override
		public String toString() {
			return "Robot [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + ", commands=" + commands + "]";
		}

		/*
		 * 
		 *  동 1
		 *  서 2
		 *  남 3
		 *  북 4
		 * 
		 * */
		public int changeDir(int changeDir) {
			this.commands.add(changeDir);
			
			//changeDir == 0 왼쪽
			//changeDir == 1 오른쪽
			
			if(this.dir == 1) {
				if(changeDir == 0) return 4;
				else return 3;
			}
			
			if(this.dir == 2) {
				if(changeDir == 0) return 3;
				else return 4;
			}
			
			if(this.dir == 3) {
				if(changeDir == 0) return 1;
				else return 2;
			}
			
			if(this.dir == 4) {
				if(changeDir == 0) return 2;
				else return 1;
			}
			
			throw new IllegalStateException();			
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
	
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<m; j++) {
				
				int n = Integer.valueOf(tk.nextToken());
				map[i][j] = n;
				
			}
			
		}
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int startX = Integer.valueOf(tk.nextToken())-1;
		int startY = Integer.valueOf(tk.nextToken())-1;
		int curDir = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int desX = Integer.valueOf(tk.nextToken())-1;
		int desY = Integer.valueOf(tk.nextToken())-1;
		int desDir = Integer.valueOf(tk.nextToken());
		
		int result = bfs(startX,startY, curDir, desX, desY,desDir);
		System.out.println(result);
	}

	private static int bfs(int startX, int startY, int curDir, int desX, int desY, int desDir) {

		
		Queue<Robot> que = new LinkedList<>();
		boolean[][][] ch = new boolean[n][m][5];
		
		que.add(new Robot(startX,startY,curDir, 0));
		
		while(!que.isEmpty()) {
			
			Robot r = que.poll();
			if(ch[r.x][r.y][r.dir]) continue;
			
			if(r.x == desX&& r.y == desY && r.dir == desDir) {
				return r.cnt;
			}

			ch[r.x][r.y][r.dir] = true;
			
			/**
			 * 0 => 1 이동
			 * 1 => 2 이동
			 * 2 => 3 이동
			 * 3 => 왼쪽
			 * 4 => 오른쪽
			 */
			for(int i=0; i<5; i++) {
				if(i<=2) {
					
					int nextX = getNextX(r.x, i+1, r.dir);
					int nextY = getNextY(r.y, i+1, r.dir);
					
					if(isOutOfBound(nextX, nextY)) continue;
					if(ch[nextX][nextY][r.dir]) continue;
					if(isBlocked(r, nextX,nextY)) continue;
					
					que.add(new Robot(nextX,nextY, r.dir, r.cnt+1));
					
				}else {
					
					int nextDir = -1;
					if(i == 3) {
						nextDir = r.changeDir(0);
						
					}else {
						
						nextDir = r.changeDir(1);
					}
					
					if(ch[r.x][r.y][nextDir]) continue;
			
					
					que.add(new Robot(r.x,r.y,nextDir, r.cnt+1));
					
				}
				
			}
			
			
		}
		
		
		return 0;
	}
	
	private static boolean isBlocked(Robot r, int nextX, int nextY) {

		if(r.dir == 1) {
			
			for(int i=r.y; i<=nextY; i++) {
				if(map[r.x][i] == 1) return true;
			}
			
		}
		
		if(r.dir == 2) {
			
			for(int i= r.y; i>=nextY; i--) {
				if(map[r.x][i] == 1) return true;
			}
			
		}
		
		if(r.dir == 3) {
			
			for(int i=r.x; i<=nextX; i++) {
				if(map[i][r.y] == 1) return true;

			}
			
		}
		
		
		if(r.dir == 4) {
			
			for(int i=r.x; i>=nextX; i--) {
				if(map[i][r.y] == 1) return true;

			}
			
		}
		
		
		return false;
	}

	private static boolean isOutOfBound(int x, int y) {
		
		if(x >= 0 && y>=0 && x< n && y<m) return false;
		return true;
		
	}

	private static int getNextY(int y, int howMany, int dir) {
		
		if(dir == 3 || dir == 4) return y;
		if(dir == 1) return y+howMany;
		if(dir == 2) return y-howMany;
		
		throw new IllegalArgumentException();
		
	}

	private static int getNextX(int x, int howMany, int dir) {

		if(dir == 1 || dir == 2) return x;
		if(dir == 3) return x+howMany;
		if(dir == 4) return x-howMany;
		
		throw new IllegalArgumentException();
		
	}

	
}
