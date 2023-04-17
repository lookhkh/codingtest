//https://www.acmicpc.net/problem/17484

package b0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17484 {

	static int n;
	static int m;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	//dir => 0 왼, 1 아래, 2 오른쪽
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<m; j++) {
				
				arr[i][j] = Integer.valueOf(tk.nextToken());
				
			}
		}
		
		for(int start=0; start<arr[0].length; start++) {
			
			for(int dir=0; dir<3; dir++) {
				dfs(start,dir, 0, arr[0][start]);
			}
			
		}

		System.out.println(min);
	}

	private static void dfs(int start, int dir, int cnt, int sum) {
		
		if(cnt == arr.length-1) {
			min = Math.min(sum, min);
		}else {
			
			for(int i=0; i<3; i++) {
				
				if(i == dir) continue;
				int next = start+getDirection(dir);
				if(!(next>=0 && next<arr[0].length)) continue;
				
				dfs(next,i,cnt+1, sum+arr[cnt+1][next]);
				
			}
			
		}

	}

	private static int getDirection(int dir) {
		if(dir == 0) return -1;
		if(dir == 1) return 0;
		return 1;
		
	}
}
