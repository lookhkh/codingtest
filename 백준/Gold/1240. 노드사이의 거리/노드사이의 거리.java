
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
	}

	static int[][] map;
	static List<List<Edge>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		map = new int[n+1][n+1];
		list = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<n-1; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int a1 = Integer.valueOf(tk.nextToken());
			int a2 = Integer.valueOf(tk.nextToken());
			int cost = Integer.valueOf(tk.nextToken());
			
			map[a1][a2] = cost;
			map[a2][a1] = cost;
			list.get(a1).add(new Edge(a2,cost));
			list.get(a2).add(new Edge(a1,cost));
			
		}
		
		for(int i=1; i<=n; i++) {
			
			bfs(i);
			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int a1 = Integer.valueOf(tk.nextToken());
			int a2 = Integer.valueOf(tk.nextToken());
			
			bw.write(map[a1][a2]+"\n");
			
		}
		
		bw.flush();
		bw.close();
	}

	private static void bfs(int start) {

			Queue<Edge> que = new LinkedList<>();
			
			boolean[] ch = new boolean[map.length];
			
			ch[start] = true;
			
			que.add(new Edge(start,0));
			
			while(!que.isEmpty()) {
				
				Edge next = que.poll();
				
				map[start][next.to] = next.cost;
								
				List<Edge> sub = list.get(next.to);
				
				for(int i=0; i<sub.size(); i++) {
					
					int nextOne = sub.get(i).to;
					
					if(ch[nextOne]) continue;
					
					ch[nextOne] = true;
					
					que.add(new Edge(nextOne,next.cost+sub.get(i).cost));
						
					
					
				}
				
				
			}
		
	}
}
