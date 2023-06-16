import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int x;
	static int y;
	static int[] arr;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		x = Integer.valueOf(tk.nextToken())-1;
		y = Integer.valueOf(tk.nextToken())-1;
		
		arr = new int[2*n];
		int idx = 0;
		for(int i=1; i<=n; i++) {
			arr[idx++] = i;
			arr[idx++] = i;
		}
		
		int[] a = new int[2*n];
		
		boolean[] ch = new boolean[n+1];
		
		a[x] = a[y] = y-x-1;
		ch[y-x-1] = true;
		
		dfs(2*n, 0, a, ch);
		System.out.println(cnt);
	}
	private static void dfs(int tar, int cur, int[] r, boolean[] ch) {
		
		if(tar == cur) {
			
			cnt++;
			return;
			
		}else {
			
			if(r[cur] ==0) {
				
				for(int i=1; i<=n; i++) {
					if(ch[i]) continue;
					if(cur+i+1 >= r.length || r[cur+i+1] !=0) continue;
					
					ch[i] = true;
					r[cur]=r[cur+i+1] = i;
					dfs(tar, cur+1, r, ch);
					ch[i] = false;
					r[cur]=r[cur+i+1] = 0;
				}
				
			}else {
				dfs(tar, cur+1, r, ch);
			}
			
			
		}

	}
}