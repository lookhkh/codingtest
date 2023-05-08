import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int ans = 0;
	static List<List<Integer>> graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.valueOf(br.readLine());
		int n = Integer.valueOf(br.readLine());

		graph = new ArrayList<>();
		
		for(int i=0; i<=k; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<n; i++) {
			
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
			
		}
		
		
		boolean[] ch = new boolean[k+1];
		ch[1] = true;
		
		dfs(1,ch);
		
		System.out.println(ans);
		
	}
	private static void dfs(int start, boolean[] ch) {
				
		List<Integer> sub = graph.get(start);
		
		if(start!=1) {
			ans++;
		}

		for(int w : sub) {
			
			if(ch[w]) continue;
			
			ch[w] = true;
			
			dfs(w,ch);
			
			
		}
		
	}
}