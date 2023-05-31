import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge{
		int to;
		int cost;
		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [to=" + to + ", cost=" + cost + "]";
		}
		
	}
	
	static int n;
	static int m;
	static List<List<Edge>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		graph = new ArrayList<>();
		
		for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			int cost = Integer.valueOf(tk.nextToken());
			
			graph.get(from).add(new Edge(to,cost));
            graph.get(to).add(new Edge(from,cost));

		}
		
		tk = new StringTokenizer(br.readLine()," ");
		int start = Integer.valueOf(tk.nextToken());
		int end = Integer.valueOf(tk.nextToken());
		
		System.out.println(bfs(start, end));
	}
	private static int bfs(int start, int end) {
		
		PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cost, t2.cost));
		
		int[] dis = new int[graph.size()];
		
		int MAX = Integer.MAX_VALUE;
		
		Arrays.fill(dis, MAX);
		
		dis[start] = 0;
		
		que.add(new Edge(start,0));
		
		while(!que.isEmpty()) {
			
			Edge next = que.poll();
            
            if(next.to == end) return next.cost;
			
			List<Edge> sub = graph.get(next.to);
			
			for(Edge e : sub) {
				
				int sum = next.cost+e.cost;
				if(dis[e.to] > sum) {
					dis[e.to] = sum;
					que.add(new Edge(e.to,sum));
				}
				
				
			}
			
		}
	
		return -1;
	}
}