import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Wrapper{
		
		int from;
		int to;
		double dis;
		
		public Wrapper(int from, int to, double dis) {

			this.from = from;
			this.to = to;
			this.dis = dis;
		
		}

		@Override
		public String toString() {
			return "Wrapper [from=" + from + ", to=" + to + ", dis=" + dis + "]";
		}
		
		
		
	}
	
	static int n;
	static int m;
	static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		int[][] arr = new int[n+1][2];
		
		map = new int[n+1];
		
		
		for(int i=0; i<map.length; i++) {
			map[i] = i;
		}
		
		
		
		for(int i=1; i<=n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int x = Integer.valueOf(tk.nextToken());
			int y = Integer.valueOf(tk.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;			
		}
		
		for(int i=0; i<m; i++) {
		
			tk = new StringTokenizer(br.readLine()," ");
			int x = Integer.valueOf(tk.nextToken());
			int y = Integer.valueOf(tk.nextToken());
			
			union(x,y);
		}
		
		PriorityQueue<Wrapper> que = new PriorityQueue<>((t1,t2)->Double.compare(t1.dis,t2.dis));

		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				
				int[] first = arr[i];
				int[] second = arr[j];
				
				double distance = getDistance(first,second);
				que.add(new Wrapper(i,j,distance));
				
			}
		}
		
		double result = 0;
        
		while(!que.isEmpty()) {
			
			Wrapper wrapper = que.poll();
			
			if(find(wrapper.from) != find(wrapper.to)) {
				union(wrapper.from, wrapper.to);
				result+=wrapper.dis;
			}
			
		}
		print(result); 

		
	}
	private static void print(double result) {
//		result = (result * 1000) / 1000.0;
//		result = Math.round(result);
        System.out.println(String.format("%.2f", result));
	}
	private static double getDistance(int[] first, int[] second) {

		return Math.sqrt( Math.pow(first[0] - second[0], 2) + Math.pow(first[1] - second[1], 2)  );
	}
	private static int find(int x) {
		if(x == map[x]) return x;
		return map[x] = find(map[x]);
	}
	private static void union(int x, int y) {

		int ax = find(x);
		int ay = find(y);
		
		if(ax!=ay) map[ay] = ax;
	}
}
