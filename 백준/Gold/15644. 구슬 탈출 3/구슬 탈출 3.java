import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static char[][] map;
	
	static int[] red = new int[2];
	static int[] blue = new int[2];
	static int[] hole = new int[2];
	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};
	
	static char[] cmd = new char[] {'L','R','U','D'};
	
	static Set<String> cmds = new HashSet<>();
	
	static class Point{
		int[] cur;
		int[] previous;
		
		public Point(int[] cur) {
			this.cur = new int[] {cur[0],cur[1]};
			this.previous = new int[] {cur[0],cur[1]};
		}
		
		public boolean movable(char dir) {
			
			if(map[this.cur[0]][this.cur[1]] == 'O') return false;
			
			if(dir == 'L') {
				if(this.cur[1]-1 >=0 && map[cur[0]][cur[1]-1] !='#') return true;
				return false;
			}
			
			else if(dir =='U') {
				if(this.cur[0]-1 >=0 && map[cur[0]-1][cur[1]] !='#') return true;
				return false;
			}
			
			else if(dir =='R') {
				if(this.cur[1]+1 < map[0].length && map[cur[0]][cur[1]+1] !='#') return true;
				return false;
			}
			
			else{
				if(this.cur[0]+1 < map.length && map[cur[0]+1][cur[1]] !='#') return true;
				return false;
			}
		}

		public void move(char dir) {

			if(dir == 'L') {
				this.cur[1]-=1;
			}
			
			else if(dir =='U') {
				this.cur[0]-=1;
			}
			
			else if(dir =='R') {
				this.cur[1]+=1;
			}
			
			else{
				this.cur[0]+=1;
			}
			
		}

		public boolean isSamePositionWith(Point b) {
			
			return this.cur[0] == b.cur[0] && this.cur[1] == b.cur[1];
		}

		public void changePosition(char dir, Point t) {
			
			if(dir == 'L') {
				if(this.previous[1] > t.previous[1]) this.cur[1]+=1;
				else t.cur[1]+=1;
			}
			
			else if(dir =='U') {
				if(this.previous[0] > t.previous[0]) this.cur[0]+=1;
				else t.cur[0]+=1;
			}
			else if(dir =='R') {
				if(this.previous[1] > t.previous[1]) t.cur[1]-=1;
				else this.cur[1]-=1;
			}
			else{
				if(this.previous[0] > t.previous[0]) t.cur[0]-=1;
				else this.cur[0]-=1;

			}
			
		}

		public void update() {
			this.previous[0] = this.cur[0];
			this.previous[1] = this.cur[1];
		}

		public boolean check() {
			return map[this.cur[0]][this.cur[1]]=='O';
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		map = new char[n][m];
		
		for(int i=0; i<n; i++) {
			String next = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = next.charAt(j);
				if(map[i][j] =='R') {
					red[0] = i;
					red[1] = j;
				}else if(map[i][j] =='B') {
					blue[0] = i;
					blue[1] = j;
				}else if(map[i][j] =='O') {
					
				}
			}
		}
		
		dfs(0,"",' ');
		List<String> r = new ArrayList<>(cmds);
		cmds.clear();
		r.sort((t1,t2)->Integer.compare(t1.length(), t2.length()));
		
		boolean result = simulate(r);
	}
	private static boolean simulate(List<String> r) {

		for(String next : r) {
			
			Point redBal = new Point(red);
			Point blueBal = new Point(blue);
			boolean result = true;
			
			for(int i=0; i<next.length() && result; i++) {
			
				char nextDir = next.charAt(i);
				if(next.equals("LDRDL")) {
					int w= 1;
				}
				while(redBal.movable(nextDir) || blueBal.movable(nextDir)) {
					
					if(redBal.movable(nextDir)) {
						redBal.move(nextDir);
					}
					if(blueBal.movable(nextDir)) {
						blueBal.move(nextDir);
					}
					
					boolean redR = redBal.check();
					boolean blueR = blueBal.check();
					
					if(redR) {
						
						if(blueBal.movable(nextDir)) continue;
						
						if(blueR) {
							result = false;
							break;
						};
						
						System.out.println(next.length());
						System.out.println(next);
						
						return true;

					}
					
					if(redBal.isSamePositionWith(blueBal)) {
						redBal.changePosition(nextDir,blueBal);
						break;
					}
				}
				redBal.update();
				blueBal.update();

				
			}
			
		}
		System.out.println(-1);
		return false;
	}
	private static void dfs(int idx, String cur, char lastOne) {
		
		cmds.add(cur);

		if(idx == 10) {
			return;
		}else {
		
			for(int i=0; i<cmd.length; i++) {
				
				char next = cmd[i];
				if(lastOne == next) continue;
				dfs(idx+1, cur+next, next);
				
			}
		}

	}
}