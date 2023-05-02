
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[] arr;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(m,0, new boolean[n], new int[m]);
		bw.flush();
	}
	
	public static void dfs(int target ,int cur, boolean[] ch, int[] path) throws IOException {
		
		if(cur == target) {
			String t ="";
			for(int w : path) {
				t+=w+" ";
			}
			bw.append(t+"\n");
			
		}else {
			
			for(int i=0; i<arr.length; i++) {
				
			
				
				path[cur] = arr[i];
				
				dfs(target, cur+1, ch, path);
				
				
			}
			
		}
		
	}
}
