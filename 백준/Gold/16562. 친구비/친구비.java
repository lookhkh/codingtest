import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int k;
	
	static Wrapper[] costs;
	
	static int[] map;
	
	static class Wrapper{
		
		public Wrapper(int i, Integer valueOf) {
			this.idx = i;
			this.cost = valueOf;
		}
		int idx;
		int cost;
	
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		
		costs = new Wrapper[n+1];
		map = new int[n+1];
		
		for(int i=0; i<map.length; i++) {
			map[i] = i;
		}
		
		tk = new StringTokenizer(br.readLine()," ");
		
		PriorityQueue<Wrapper> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cost, t2.cost));
		
		for(int i=1; i<n+1; i++) {
			costs[i] = new Wrapper(i,Integer.valueOf(tk.nextToken()));
			que.add(costs[i]);
			
		}
		
		for(int i=0; i<m; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());	
			int to = Integer.valueOf(tk.nextToken());	
			
			
			if(find(from) != find(to)) union(from, to);
			
		}

		int me = 0;
		long cost = 0;
		while(!que.isEmpty() && k>=0) {
			
			Wrapper next = que.peek();
			
			if(find(next.idx)!=find(0)) {
				cost  += next.cost;
				k-= next.cost;
				union(me, next.idx);
			}
			
			if(k>=0) que.poll();
			
		}
		
		
		if(que.isEmpty()) System.out.println(cost);
		else System.out.println("Oh no");

	}

	private static void union(int from, int to) {
		
		from = find(from);
		to = find(to);
		
		if(from != to) map[from] = to;
		
	}

	private static int find(int from) {
		
		if(from == map[from]) return from;
		
		return map[from] = find(map[from]);
	}
	
	
}
