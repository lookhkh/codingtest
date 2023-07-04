
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int[] pos;
		int times;
		
		public Node(int[] pos, int times) {
			this.pos = pos;
			this.times = times;
		}

		public boolean isSame(int[] target) {
			return this.pos[0] == target[0] && this.pos[1] == target[1];
		}
		
	}
	static int[] dirX = new int[] {-1,-2,-2,-1,1,2, 2, 1};
	static int[] dirY = new int[] {-2,-1, 1, 2,2,1,-1,-2};
	
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		
		for(int i=0; i<t; i++) {
			
			n = Integer.valueOf(br.readLine());
			
			StringTokenizer cur = new StringTokenizer(br.readLine()," ");
			
			int curX = Integer.valueOf(cur.nextToken());
			int curY = Integer.valueOf(cur.nextToken());
			
			StringTokenizer target = new StringTokenizer(br.readLine()," ");
			int targetX = Integer.valueOf(target.nextToken());
			int targetY = Integer.valueOf(target.nextToken());
			
			int r = bfs(new int[] {curX,curY}, new int[] {targetX,targetY});
			System.out.println(r);
			
			
		}
	}

	private static int bfs(int[] cur, int[] target) {
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(cur, 0));
		boolean[][] ch = new boolean[n][n];
		ch[cur[0]][cur[1]] = true;
		
		while(!que.isEmpty()) {
			
			Node next = que.poll();
			if(next.isSame(target)) {
				return next.times;
			}
			
			for(int i=0; i<8; i++) {
				
				int nextX = next.pos[0]+dirX[i];
				int nextY = next.pos[1]+dirY[i];
				
				if(nextX>=0 && nextY>=0 && nextX<n && nextY <n) {
					if(ch[nextX][nextY]) continue;
					ch[nextX][nextY] = true;
					que.add(new Node(new int[] {nextX,nextY},next.times+1));
					
				}
			}
			
		}
		
		return 0;
	}
}
