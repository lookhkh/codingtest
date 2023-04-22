import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[][] arr;
	static int answer = Integer.MIN_VALUE;
	
	
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
		
		for(int i=1; i<=3; i++){
			combination(i,0, 0, new int[i]);
		}
		
		System.out.println(answer);
		
	}
	private static void combination(int target, int current, int startIdx, int[] path) {

		
		if(current == target) {
			
			
			int temp = 0;
			for(int i=0; i<arr.length; i++) {
				
				int[] row = arr[i];
				
				int result = Integer.MIN_VALUE;
				
				for(int j=0; j<path.length; j++) {
					
					result = Math.max( row[path[j]] , result );
					
				}
				
				temp+=result;
				
			}
			
			answer = Math.max(answer, temp);
			
			
		}else {
			
			for(int i=startIdx; i<m; i++) {
				
				path[current] = i ;
				combination(target, current+1, i+1, path);
				
			}
			
		}
		
	}
}
