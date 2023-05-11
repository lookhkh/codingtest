import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static String target;
	static String b1;
	static String b2;
	static int length;
	
	static long[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = br.readLine();

		b1 = br.readLine();
		b2 = br.readLine();
		length = b1.length();
		dp = new long[2][21][length+1];
		
		for(long[][] w : dp) {
			for(long[] p : w) {
				Arrays.fill(p, -1);
			}
		}
		
		long cntFirstB = dfs(0,0,true);
		long cntSecondB = dfs(0,0,false);
		
		System.out.println(cntFirstB+cntSecondB);
	}
	private static long dfs(int curIdx, int idx, boolean isFirst) {
		
		if(curIdx>b1.length()-1) return dp[isFirst?0:1][curIdx][idx] = 0;
		if(curIdx == target.length()) return dp[isFirst?0:1][curIdx][idx] =1;
		if(dp[isFirst?0:1][curIdx][idx]!=-1) return dp[isFirst?0:1][curIdx][idx];
		
		int cnt = 0;
		
		if(isFirst) {
			
			for(int i=idx; i<length; i++) {
				
				char next = b1.charAt(i);
				if(next == target.charAt(curIdx)) {
					cnt+=dfs(curIdx+1,i+1, !isFirst);
				}
				
			}
			
		}else {
			
			for(int i=idx; i<length; i++) {
				
				char next = b2.charAt(i);
				if(next == target.charAt(curIdx)) {
					cnt+=dfs(curIdx+1,i+1, !isFirst);
				}
				
			}
			
		}
		

		
		return dp[isFirst?0:1][curIdx][idx] = cnt;
	}
}