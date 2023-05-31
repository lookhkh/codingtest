import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static int n;
	static int m;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		if(m == 0) {
			System.out.println(1);
			return;
		}
		
		list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine()," ");
			list.add(new int[] {Integer.valueOf(tk.nextToken()),Integer.valueOf(tk.nextToken())});
		}
		
		dfs(0,new boolean[n+1], new boolean[m],0);
		System.out.println(max);
	}
	private static void dfs(int idx,boolean[] mems, boolean[] pair, int cnt) {
		
		if(cnt == n) {
			max = n;
			return;
		}else {
			max = Math.max(cnt+1, max);
		}
		
		if(max == n) return;
		
		for(int i=idx; i<list.size(); i++) {
			int[] arr = list.get(i);
			if(pair[i]) continue;
			if(mems[arr[0]] || mems[arr[1]]) continue;
			
			pair[i] = true;
			mems[arr[0]] = mems[arr[1]] = true;
			dfs(i+1,mems,pair, cnt+2);
			pair[i] = false;
			mems[arr[0]] = mems[arr[1]] = false;
			
		}
		
	}
}
