import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] arr;
	static List<List<Integer>> c = new ArrayList<>();

	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};
	
	
	static class Point{
		
		public Point(Integer x, Integer y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		
		int x;
		int y;
		int cnt;
		// 0 - 상  1 - 하  2 - 좌  3  - 우
		int dir;
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + ", dir=" + dir + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		m = Integer.valueOf(tk.nextToken());
		n = Integer.valueOf(tk.nextToken());
		arr = new char[n][m];
		for(int i=0; i<n; i++) {
			String next = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = next.charAt(j);
				if(arr[i][j] =='C') {
					c.add(Arrays.asList(i,j));
				}
			}
		}
		
		int result = bfs(c.get(0),c.get(1));
		System.out.println(result);

	}

	private static int bfs(List<Integer> s, List<Integer> e) {
		int[] start = new int[] {s.get(0),s.get(1)};
		int[] end = new int[] {e.get(0),e.get(1)};
		
		Queue<Point> que = new LinkedList<>();
		
		que.add(new Point(start[0],start[1],0,0));
		que.add(new Point(start[0],start[1],1,0));
		que.add(new Point(start[0],start[1],2,0));
		que.add(new Point(start[0],start[1],3,0));

		int[][][] ch = new int[arr.length][arr[0].length][4];
		
		for(int[][] w : ch) {
			for(int[] p : w) {
				Arrays.fill(p, Integer.MAX_VALUE);
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		while(!que.isEmpty()) {
			
			Point next = que.poll();
		
			if(next.x == end[0] && next.y == end[1]) {
				min = Math.min(min, next.cnt);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				
				int nextX = next.x+dirX[i];
				int nextY = next.y+dirY[i];
				
				if(nextX>=0 && nextY>=0 && nextX< arr.length && nextY < arr[0].length) {
					
					if(arr[nextX][nextY] == '*') continue;
					int cnt = next.cnt;
					
					if( i != next.dir) cnt+=1;
					
					if(ch[nextX][nextY][i] <= cnt) continue;
					
					ch[nextX][nextY][i] = cnt;
					
					que.add(new Point(nextX,nextY,i,cnt));
					
					
					
				}
				
				
			}
			
		}
		
		return min;
	}

}
