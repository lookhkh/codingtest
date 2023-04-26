
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
	static int k;
	
	static List<List<Edge>> edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		
		edges = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			edges.add(new ArrayList<>());
		}
		
		
		for(int i=0; i<m; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			int cost = Integer.valueOf(tk.nextToken());
			
			edges.get(from).add(new Edge(to,cost));
			
			
		}
		
		long max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			
			int next = i;
			
			long homeToParty = bfs(next,k);
			long partyToHome = bfs(k,next);
			
			
			max = Math.max(max, homeToParty+partyToHome);
		}
		
		System.out.println(max);
		
	}

	private static long bfs(int nextOne, int des) {

		PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cost, t2.cost));
		que.add(new Edge(nextOne,0));
		
		long[] dis = new long[n+1];
		
		Arrays.fill(dis, Long.MAX_VALUE);
		
		
		boolean[] ch=  new boolean[n+1];
		ch[nextOne] = true;
		
		
		while(!que.isEmpty()) {
			
			
			Edge next = que.poll();
			ch[next.to] = true;
			
			if(next.to == des) {
				
				return next.cost;
			}
			
			List<Edge> sub = edges.get(next.to);
			
			for(Edge e : sub) {
				
				int cost = e.cost+next.cost;
				if(ch[e.to]) continue;
				if(dis[e.to] > cost) {
					
					dis[e.to] = cost;
					que.add(new Edge(e.to, cost));
					
				}
				
			}
			
			
			
			
		}
		
		return 0;
	}
}
