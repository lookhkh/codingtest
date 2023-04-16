//https://www.acmicpc.net/submit/2026/59483806

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

	static List<List<Integer>> graph;
	static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		k = Integer.valueOf(tk.nextToken());
		int n = Integer.valueOf(tk.nextToken());
		int f = Integer.valueOf(tk.nextToken());
		
		graph = new ArrayList<>();
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for(int i=0; i<f; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			int from = Integer.valueOf(tk.nextToken());
			int to = Integer.valueOf(tk.nextToken());
			
            if(!graph.get(from).contains(to))graph.get(from).add(to);
			if(!graph.get(to).contains(from))graph.get(to).add(from);
			
		}
        
		graph
            .stream()
            .forEach(t->t.sort(null));

		for(int i=1; i<=n; i++) {
			int cnt = 0;
			
			List<Integer> nextGraph = graph.get(i);
			if(nextGraph.size()<k-1) continue;
			
			List<Integer> path = new ArrayList<>();
			path.add(i);
			dfs(i,new boolean[n+1],path, 0);
		
		
		}
		
		System.out.println(-1);
		
		
	}

	private static void dfs(int start, boolean[] ch, List<Integer> path, int currentIdx) {

		if(currentIdx == k-1) {

			path.stream().forEach(System.out::println);
			
			System.exit(0);
		}else {
			
			List<Integer> subgraph = graph.get(start);
			
			for(int i=0; i<subgraph.size(); i++) {
				
				int next = subgraph.get(i);
				
				if(!isAllFreind(next, path)) continue;
				
				appendCurrentIdx(ch, path, next);
				
				dfs(next, ch, path, currentIdx+1);
				
				removeCurrentIdx(ch, path, next);
			}
			
			
		}
		
	}

	private static boolean isAllFreind(int next, List<Integer> path) {
		
		List<Integer> sub = graph.get(next);
		
		return sub.containsAll(path);
		
	}

	private static void removeCurrentIdx(boolean[] ch, List<Integer> path, int next) {
		path.remove(path.size()-1);
		
		ch[next] = false;
	}

	private static void appendCurrentIdx(boolean[] ch, List<Integer> path, int next) {
		ch[next] = true;
		
		path.add(next);
	}

	

}
