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
		int dis;
		public Edge(int to, int dis) {
			this.to = to;
			this.dis = dis;
		}
		@Override
		public String toString() {
			return "Edge [to=" + to + ", dis=" + dis + "]";
		}
		
	}
	
	static int n;
	static int m;
	static int x;
	static int y;
	static List<List<Edge>> edges = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		x = Integer.valueOf(tk.nextToken());
		y = Integer.valueOf(tk.nextToken());
		
		for(int i=0; i<n; i++) {
			edges.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			int dis = Integer.valueOf(tk.nextToken());
			
			edges.get(from).add(new Edge(to,dis));
			edges.get(to).add(new Edge(from,dis));
		}
		
		List<Edge> minDis = bfs(y);
		
		for(Edge e : minDis) {
			if(e.dis*2 > x) {
				System.out.println(-1);
				return;
			}
		}
		
		PriorityQueue<Edge> que = 
				new PriorityQueue<>((t1,t2)->Integer.compare(t1.dis, t2.dis));
	
		que.addAll(minDis);
		
		int day = 1;
		int tempSum = 0;
		
		while(!que.isEmpty()) {
			
			Edge next = que.peek();
			tempSum += next.dis * 2;
			
			if(tempSum <=x) {
				que.poll();
			}else {
				tempSum = 0;
				day++;
			}
		}
		System.out.println(day);
		

	}
	private static List<Edge> bfs(int start) {

		int[] dis = new int[n];
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.dis, t2.dis));
		que.add(new Edge(start,0));
		
		while(!que.isEmpty()) {
			
			Edge next = que.poll();
			
			List<Edge> sub = edges.get(next.to);
			
			for(Edge n : sub) {
				
				int totalDis = n.dis+next.dis;
				
				if(dis[n.to] > totalDis) {
					
					dis[n.to] = totalDis;
					que.add(new Edge(n.to, totalDis));
					
				}
				
			}
			
		}
		
		List<Edge> r = new ArrayList<>();
		for(int i=0; i<dis.length; i++) {
			r.add(new Edge(i,dis[i]));
		}

		
		return r;
	}
}
