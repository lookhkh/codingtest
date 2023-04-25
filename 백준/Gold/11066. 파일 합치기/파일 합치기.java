import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        int nums = Integer.valueOf(br.readLine());
		        
		        
		        for(int idx = 0; idx<nums; idx++) {
		        	
			        int num = Integer.valueOf(br.readLine());
			        StringTokenizer tk =new StringTokenizer(br.readLine()," ");
			        arr = new int[num+1];
			        dp = new long[num+1][num+1];
			        
			        for(long[] w : dp) {
			        	Arrays.fill(w, Long.MAX_VALUE);
			        }
			        
			        for(int i=0; i<num; i++) {
			        	int next = Integer.valueOf(tk.nextToken());;
			        	if(i==0) arr[i+1] = next;
			        	else arr[i+1] = arr[i]+next;
			        }
			        
			        long result = getDp(1, arr.length-1);
			        
			        System.out.println(result);
		        	
		        	
		        }
		        
	
		}
	private static long getDp(int start, int end) {

		if( start > end) return 0;
		if( start == end ) return 0;
		if(dp[start][end]!= Long.MAX_VALUE) return dp[start][end];

		if( start+1 == end ) return dp[start][end] = arr[end] - arr[start-1];
		
		
		for(int i=start; i<=end; i++) {
			
			
			dp[start][end] = Math.min( dp[start][end], getDp(start,i)+getDp(i+1, end) + arr[end] - arr[start-1]);
			
		}
				
		return dp[start][end];
		}
}
