import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 
 * 학생들의 키를 비교한다.
 * 이때 학생들의 키는 모두 다르다.
 * 
 * 
 * */public class Main {

		
		static List<List<Integer>> tallGraph;
		static List<List<Integer>> shortGraph;
				
		
		static int n;
		
		static int m;
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tk = new StringTokenizer(br.readLine());
			
			n = Integer.valueOf(tk.nextToken());
			m = Integer.valueOf(tk.nextToken());
			
			shortGraph = new ArrayList<>();
			tallGraph  = new ArrayList<>();
			
			for(int i=0; i<=n; i++) {
				shortGraph.add(new ArrayList<>());
				tallGraph.add(new ArrayList<>());
			}

			for(int i=0; i<m; i++) {
				
				tk = new StringTokenizer(br.readLine());
				int from = Integer.valueOf(tk.nextToken());
				int to = Integer.valueOf(tk.nextToken());
				
				
				tallGraph.get(from).add(to);
				shortGraph.get(to).add(from);
			}

			
			Queue<Integer> que = new LinkedList<>();
			boolean[] ch = new boolean[n+1];
			
			int answer=0;
			for(int i=0; i<=n; i++) {
				
				int tallOne = bfs(i,tallGraph,que,ch);
				int shortOne = bfs(i,shortGraph,que,ch);
				
				if(tallOne + shortOne == n-1) answer++;
			}
			
			System.out.println(answer);
			
		
			
		}

		private static int bfs(int start, List<List<Integer>> g, Queue<Integer> que, boolean[] ch) {

			que.clear();
			for(int i=0; i<ch.length; i++) {
				ch[i] = false;
			}
			
			que.add(start);
			ch[start]= true;
			int answer = -1;
			
			while(!que.isEmpty()) {
				
				int next = que.poll();
				answer++;
				
				List<Integer> sub = g.get(next);
				
				for(int n : sub) {
					if(ch[n]) continue;
					ch[n] = true;
					que.add(n);
				}
				
			}
			
			
			return answer;
		}
	}