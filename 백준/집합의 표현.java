//https://www.acmicpc.net/problem/1717

package b0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717 {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		arr = new int[n+1];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int cmd = Integer.valueOf(tk.nextToken());
			int a = Integer.valueOf(tk.nextToken());
			int b = Integer.valueOf(tk.nextToken());
			
			if(cmd ==0 ) union(a,b);
			else {
				if(find(a)==find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
			
		}
	}

	private static void union(int a, int b) {
		
		int at = find(a);
		int bt = find(b);
		
		if(at != bt) arr[bt] = at;
		
	}

	private static int find(int a) {
		
		if(arr[a] == a) return a;
		return arr[a] = find(arr[a]);
	}
}
