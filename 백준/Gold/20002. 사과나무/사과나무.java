
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[][] arr = new int[n][n];
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<n; j++) {
				
				arr[i][j] = Integer.valueOf(tk.nextToken());
				
			}	
		}
		
		int[][] sum = new int[n][n];
		sum[0][0] = arr[0][0];
		
		for(int i=1; i<n; i++) {
			sum[0][i] = sum[0][i-1]+arr[0][i]; 
			sum[i][0] = sum[i-1][0]+arr[i][0];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
				sum[i][j] = arr[i][j]+ sum[i][j-1]+sum[i-1][j] - sum[i-1][j-1];
			}
		}
				
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				for(int k = 0; k+i < n && k+j < n; k++) {
					
					int result = sum[i+k][j+k];
					
					/*
					 * 
					 * 0,1 -> 1,2
					 * 
					 * */
					
					if(i-1>=0) result -= sum[i-1][j+k];
					if(j-1>=0)result -= sum[i+k][j-1];
					if(i-1 >=0 && j-1 >=0)result += sum[i-1][j-1];
				
					
					max = Math.max(max, result);
					
				}
				
			}
		}

		System.out.println(max);
		
		int t= 1;
		
		
		/*
		 * 
		 * arr[0][1] ~ arr[1][2]
		 * sum[1][2] - sum[1][0]
		 * 
		 * 
		 * arr[1][1] ~ arr[2][2]
		 * sum[2][2] - sum[2][0] - sum[0][2] + sum[0][0]
		 * 
		 *  
		 *  arr[1][0] ~ arr[2][1]
		 *  
		 *  sum[2][1] - sum[0][2] - sum[1][2] + arr[0][2]
		 * */
		
		
		
		
	}

}
