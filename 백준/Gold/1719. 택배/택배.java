import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	
	static int n;
	static int m;
	static List<List<Edge>> graph;
	
	static class Edge{
		int to;
		int dis;
		int first;
		public Edge(int to, int dis) {

			this.to = to;
			this.dis = dis;
			this.first = -1;
			
		}


		public void updateFirstDestination(int des) {
			first = des;
		}
		
		
	}
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		map = new int[n+1][n+1];
		
		graph = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			int dis = Integer.valueOf(tk.nextToken());
			
			graph.get(from).add(new Edge(to,dis));
			graph.get(to).add(new Edge(from,dis));
			
			
		}
		
		for(int i=1; i<=n; i++) {
			bfs(i);
		}


		printResult();
		
		
	}

	private static void printResult() {
		for(int i=1; i<map.length; i++) {
			
			String t="";
			for(int j=1; j<map[i].length; j++) {
				
				int next = map[i][j];
				
				if(next == -1) t+="-"+" ";
				else t+=next+" ";
				
			}
			t = t.substring(0,t.length()-1);
			
			System.out.println(t);
		}
	}

	private static void bfs(int start) {
		
		PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.dis, t2.dis));
		int[] distance = new int[n+1];
		boolean[] ch = new boolean[n+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		que.add(new Edge(start, 0));
		
		
		while(!que.isEmpty()) {
			
			Edge next = que.poll();
			
			if(ch[next.to]) continue;
			
			if(distance[next.to] > next.dis) {
				//System.out.println(start+" => "+next.to+"  "+next);
				distance[next.to] = next.dis;
				map[start][next.to] = next.first;
				ch[next.to] = true;
			}
			
			List<Edge> sub = graph.get(next.to);
			
			for(Edge e : sub) {
				
				int nextTo = e.to;
				
				int wholeDis = e.dis+next.dis;
				
				if(distance[nextTo] > wholeDis) {
										
					Edge nextOne = new Edge(nextTo, wholeDis);
					
					if(next.first == -1)nextOne.first = e.to;
					else nextOne.first = next.first;
					
					que.add(nextOne);
					
				}
				
			}
		}
//		
//		String t ="";
//		for(int w : distance) {
//			t+=w+" ";
//		}
//		
//		System.out.println(t);
	}
}
