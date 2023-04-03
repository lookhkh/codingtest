//https://www.acmicpc.net/problem/16202

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16202 {

	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		int from;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [to=" + to + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int n;
	static int m;
	static int k;
	static LinkedList<Edge> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		
		int[] answer = new int[k];
		graph = new LinkedList<>();

		for(int i=1; i<m+1; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			
			graph.add(new Edge(from,to,i));
			
		}
		
		graph.sort(null);
		
		for(int i=0; i<k; i++) {
			
			if(i>0 && answer[i-1] == 0) {
				break;
			}
			
			PriorityQueue<Edge> que = new PriorityQueue<>();
			que.addAll(graph);
			
			int[] map = new int[n+1];
			
			for(int j=1; j<map.length; j++) {
				map[j] = j;
			}
			
			int r = 0;
			
			int cnt = 0;
			while(!que.isEmpty()) {
				
				
				Edge e = que.poll();
				
				int from = e.from;
				int to = e.to;
				
				if(find(from,map)!=find(to,map)) {
					r+=e.cost;
					cnt++;
					union(from,to,map);
				}
				
			}
			
			if(cnt == n-1) answer[i] = r;
			Edge e =graph.removeFirst();

			
		}
		StringBuilder b = new StringBuilder();
		for(int t : answer) {
			b.append(t+" ");
		}
		
		
		System.out.println(b.toString());
		
		
	}
	private static void union(int from, int to, int[] map) {
		map[find(from,map)] = find(to,map);
		
	}
	private static int find(int from, int[] map) {
		if(map[from] == from) return from;
		return map[from] = find(map[from],map);
	}
	

}
