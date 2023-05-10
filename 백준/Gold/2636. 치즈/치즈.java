
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	
	static int[][] map;
	
	//상 하 좌 우
	static int[] dirX = new int[] {-1,1,0,0};
	static int[] dirY = new int[] {0,0,-1,1};
	
	static boolean[][] ch;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n= Integer.valueOf(tk.nextToken());
		m= Integer.valueOf(tk.nextToken());
		
		map = new int[n][m];
		
		int cntOf1 = 0;
		
		for(int i=0; i<n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<m; j++) {
				int next = Integer.valueOf(tk.nextToken());
				map[i][j] = next;
				if(next == 1) cntOf1++;
			}
			
		}
		
		int lastCnt = cntOf1;
		int elapsedTime = 0;
		while(cntOf1>0) {
			
			lastCnt = cntOf1;
					
			bfs(0,0);
			
			cntOf1 = count();
			
			elapsedTime++;
		}
		
		System.out.println(elapsedTime);
		System.out.println(lastCnt);
	}

	private static int count() {
		
		int cnt = 0;
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == -1) map[i][j] = 0;
				if(map[i][j] == 1) cnt++;
			}
		}
		
		
		return cnt;
	}


	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {x,y});
		boolean[][] ch = new boolean[n][m];
		while(!que.isEmpty()) {
			
			int[] next = que.poll();
						
			if(ch[next[0]][next[1]]) continue;
			
			ch[next[0]][next[1]] = true;
			
			
			
			for(int i=0; i<4; i++) {
				
				int nextX = next[0]+dirX[i];
				int nextY = next[1]+dirY[i];
				
				if(nextX>=0 && nextX<map.length && nextY>=0 && nextY< map[i].length){	
					
					if(ch[nextX][nextY]) continue;
					
					int what = map[nextX][nextY];
					//System.out.println(nextX+" / "+nextY+"  "+what);

					if(what == 1) {
						
						map[nextX][nextY] = -1;
						
					}else if(what == 0) {
						//System.out.println(nextX+" / "+nextY);

						que.add(new int[] {nextX,nextY});
						
					}
				
				}
			}
			
		}
		
	}
}
