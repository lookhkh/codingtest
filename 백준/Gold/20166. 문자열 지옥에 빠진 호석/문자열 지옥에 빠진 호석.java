import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Step{
		int x;
		int y;
		String b;
		
		public Step(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.b = "";
		}
		
		public Step(int x, int y, String n) {
			this.x = x;
			this.y = y;
			this.b = n;
		}
		
		public int size() {
			return this.b.length();
		}
		
		public String getString() {
			return this.b;
		}

		@Override
		public String toString() {
			return "Step [x=" + x + ", y=" + y + ", b=" + b + "]";
		}
	}
	
	
	static int n;
	static int m;
	static int k;
	static char[][] map;
	static Map<String, Integer> score;
	static int maxLength= 0;
	
	//좌상 상 우상 우 우하 하 좌하 좌
	static int[] dirX = new int[] {-1,-1,-1,0,1,1,1,0};
	static int[] dirY = new int[] {-1,0,1,1,1,0,-1,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		
		score = new HashMap<>();
		
		map = new char[n][m];
		
		for(int i=0; i<n; i++) {
			String n = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = n.charAt(j);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<k; i++) {
			String r = br.readLine();
			score.put(r, 0);
			maxLength = Math.max(maxLength, r.length());
		}
		

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				bfs(i,j);
			}
		}
		
		score.values().forEach(t->{
			try {
				bw.append(t+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.flush();


		
	}
	

	private static void bfs(int startX, int startY) {

		Queue<Step> que = new LinkedList<>();
		que.add(new Step(startX,startY,map[startX][startY]+""));
		
		while(!que.isEmpty()) {
			
			Step next = que.poll();
			
			if(next.size() > maxLength) continue;
			
			if(score.containsKey(next.getString())) {
				score.put(next.getString(), score.get(next.getString())+1);
				continue;
			}
			
			for(int i=0; i<8; i++) {
				
				int nextX = next.x+dirX[i];
				int nextY = next.y+dirY[i];
				
				if(nextX < 0) nextX = n-1;
				if(nextY < 0) nextY = m-1;
				if(nextX == n) nextX = 0;
				if(nextY == m) nextY = 0;
				
				
				que.add(new Step(nextX,nextY,next.b+map[nextX][nextY]));
				

				}
				
			}
			
		}
}
