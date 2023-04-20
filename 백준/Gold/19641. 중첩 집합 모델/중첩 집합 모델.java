import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static class Node{
		
		int idx;
		int left;
		int right;
			
		public Node(int idx) {
			this.idx = idx;
		}
			
	}
	
	static Node[] nodes;
	static int cnt = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		nodes = new Node[n+1];
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
			nodes[i] = new Node(i);
		}
		
	
		
		for(int i=0; i<n; i++) {
			StringTokenizer t = new StringTokenizer(br.readLine()," ");
			
			int start = Integer.valueOf(t.nextToken());
			while(true) {
				
				int nextNode = Integer.valueOf(t.nextToken());
				if(nextNode == -1) break;
				
				graph.get(start).add(nextNode);
				
			}
			
			graph.get(start).sort(null);
			
		}
		
		boolean[] ch = new boolean[n+1];
		int root = Integer.valueOf(br.readLine());
		ch[root] = true;
		
		inorder(root, ch);
		
		for(int i=1; i<nodes.length; i++) {
			Node nw = nodes[i];
			System.out.println(nw.idx+" "+nw.left+" "+nw.right);
		}
	}

	private static void inorder(int root, boolean[] ch) {
		
		updateNodesLeft(root, cnt);
		
		List<Integer> sub = graph.get(root);
		
		for(int i=0; i<sub.size(); i++) {
			int next = sub.get(i);
			
			if(ch[next]) continue;
			
			ch[next] = true;
			cnt +=1;
			inorder(next, ch);
			ch[next] = false;
		}
		
		nodes[root].right = ++cnt;
		
		
	}

	private static void updateNodesLeft(int root, int cnt) {
		nodes[root].left = cnt++;
	}
}
