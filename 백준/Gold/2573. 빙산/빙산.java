
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	
	static class IceBurg{
		
		
		public IceBurg(int x, int y, int remain) {
			this.x = x;
			this.y = y;
			this.remain = remain;
		}
		
		int x;
		int y;
		int remain;
		@Override
		public String toString() {
			return "IceBurg [x=" + x + ", y=" + y + ", remain=" + remain + "]";
		}
		
		
	}
	
	static int n;
	static int m;
	static int[][] map;
	static List<IceBurg> list;
	
	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		map = new int[n][m];
		list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.valueOf(tk.nextToken());
				if(map[i][j] >= 1) {
					list.add(new IceBurg(i,j,map[i][j]));
				}
			}
			
		}
		int cnt = 0;
		while(!list.isEmpty()) {
			
			cnt++;
		
			
			for(IceBurg ice : list) {
				
				for(int i=0; i<4; i++) {
					
					int nextX = ice.x+dirX[i];
					int nextY = ice.y+dirY[i];
					
					if(check(nextX,nextY)) continue;
					
					if(map[nextX][nextY] == 0) {
						ice.remain --;
					}
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				IceBurg w=  list.get(i);
				if(w.remain <= 0) map[w.x][w.y] = 0;
			}
			
			list = list.stream()
					   .filter(t->t.remain>0)
					   .collect(Collectors.toList());
			
			int r = checkchunkNum();

			if(r >= 2) {
				System.out.println(cnt);
				return;
			}
			

		}
		
		System.out.println(0);
		
	}

	private static int checkchunkNum() {
		
		boolean[][] ch = new boolean[n][m];
		int cnt = 0;
		
		for(int i=0; i<list.size(); i++) {
			
			IceBurg next = list.get(i);
			
			if(ch[next.x][next.y]) continue;

			bfs(new int[] {next.x,next.y}, ch);
			
			cnt++;
		}
		
		return cnt;
	}

	private static void bfs(int[] iceBurg, boolean[][] ch) {
		
		Queue<int[]> que = new LinkedList<>();
		
		que.add(iceBurg);
		
		while(!que.isEmpty()) {
			
			int[] next = que.poll();
			
			if(ch[next[0]][next[1]]) continue;
			
			ch[next[0]][next[1]] = true;
			
			for(int i=0; i<4; i++) {
				
				int nextX = next[0]+dirX[i];
				int nextY = next[1]+dirY[i];
				
				if(check(nextX,nextY)) continue;
				
				if(map[nextX][nextY] >= 1) {
					
					if(ch[nextX][nextY]) continue; 
					
					que.add(new int[] {nextX,nextY});
					
				}
			}
			
		}
	}

	private static boolean check(int nextX, int nextY) {
		
		if(nextX>=0 && nextY >=0 && nextX<n && nextY <m) return false;
		
		return true;
	}
}
