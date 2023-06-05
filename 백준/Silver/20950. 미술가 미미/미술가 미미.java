
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n;
	
	static int[][] arr;
	static int[] target = new int[3];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		arr = new int[n][3];
		
		for(int i=0; i<n; i++) {
			
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int r = Integer.valueOf(tk.nextToken());
			int g = Integer.valueOf(tk.nextToken());
			int b = Integer.valueOf(tk.nextToken());
			arr[i][0] = r;
			arr[i][1] = g;
			arr[i][2] = b;
			
		}
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		target[0] = Integer.valueOf(tk.nextToken());
		target[1] = Integer.valueOf(tk.nextToken());
		target[2] = Integer.valueOf(tk.nextToken());
		
		dfs(0, new int[3], 0);
		System.out.println(min);
	}
	private static void dfs(int idx, int[] result, int cnt) {
		
		if(cnt > 7) return;
		if(idx == n) {
			if(cnt == 0 || cnt == 1) return;
			int a = result[0] / cnt;
			int b = result[1] / cnt;
			int c = result[2] / cnt;
			
			int tempR = Math.abs(target[0]-a)+Math.abs(target[1]-b)+Math.abs(target[2]-c);

			min = Math.min(min, tempR);
		}else {
			
			result[0] += arr[idx][0];
			result[1] += arr[idx][1];
			result[2] += arr[idx][2];
			
			dfs(idx+1, result, cnt+1);
			
			result[0] -= arr[idx][0];
			result[1] -= arr[idx][1];
			result[2] -= arr[idx][2];
			
			dfs(idx+1, result,cnt);
		}
		
	}
}
