import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        StringBuilder sb = new StringBuilder();

	        while(true){
	            st = new StringTokenizer(br.readLine());
	            int N = Integer.parseInt(st.nextToken());
	            int M = Integer.parseInt(st.nextToken());
	            if(N==0 && M==0) break;

	            int[][] dp = new int[N+1][M+1];

	            int max = 0;
	            
	            for(int i=1; i<dp.length; i++) {
	            	
		            st = new StringTokenizer(br.readLine()," ");
	            	
	            	for(int j=1; j<dp[i].length; j++) {
	            		
	            		int next = Integer.valueOf(st.nextToken());
	            		
	            		if(next == 1) {
	            			
	            			dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
	            			max = Math.max(max, dp[i][j]);
	            		}
	            		
	            		
	            	}
	            	
	            }
	            
	            sb.append(max).append('\n');
	        }


	        System.out.println(sb);

	}
}
