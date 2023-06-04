import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Tree{
		
		List<Integer> tree;
		Set<Integer> allTree;
		
		public Tree() {
			this.tree = new ArrayList<>();
			this.tree.add(-1);
			this.allTree = new HashSet<>();
		}
		
		public void insert(int next) {
			tree.add(next);
		}
		
		public int isReachable(int idx, int lastIdx) {
						
			int answer = 0;
			int temp = idx;
			while(idx != 0) {
				
				if(allTree.contains(idx)) answer = idx;
				idx = idx>>1;
				
			}
			allTree.add(temp);

			return answer;
			
		}
		
	}
	
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		
		m = Integer.valueOf(tk.nextToken());
		
		Tree t= new Tree();
		for(int i=1; i<=n; i++) {
			t.insert(i);
		}
		
		StringBuilder  b= new StringBuilder();
		for(int i=0; i<m; i++) {
			
			int next = Integer.valueOf(br.readLine());
		
			b.append(t.isReachable(next, -1)+"\n");
		}
		
		System.out.println(b.toString());
	}
}
