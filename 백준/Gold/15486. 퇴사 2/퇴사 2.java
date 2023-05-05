import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] time;
	static long[] value;
	static long max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		n = Integer.valueOf(br.readLine());
		
		time = new int[n+1];
		value = new long[n+1];
		
		
		for(int i=1; i<=n; i++) {
			tk = new StringTokenizer(br.readLine());
			time[i] = Integer.valueOf(tk.nextToken());
			value[i] = Integer.valueOf(tk.nextToken());
		}
	
		long[] dp = new long[n+2];
		long[] max = new long[2];
		max[0] = 0; //max값의 index
		max[1] = 0; //max값의 value
		
		for(int i=1; i<=n+1; i++) {
			
			if(i > max[0]) {
				if(dp[i] > max[1]) {
					max[0] = i;
					max[1] = dp[i];
				}else {
					dp[i] = max[1];
				}
			}
			
			if(i>n) continue;
			
			int next = i+time[i];
			if(next <= n+1) {
				dp[next] = Math.max(dp[next], dp[i]+value[i]);
			}
			
		}
		
//		StringBuffer b= new StringBuffer();
//		for(long t : dp) {
//			b.append(t+" ");
//		}
//		
//		System.out.println(b.toString());
//		
		System.out.println(dp[n+1]);
		
	}

	

}
