
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static Set<String> set = new HashSet<>();
	public static long[][] dp = new long[31][61];
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner((System.in));
		int n = -1;
		for(long[] w : dp) {
			Arrays.fill(w, -1);
		}
		while((n = in.nextInt())!=0) {
			
			set = new HashSet<>();
			long r = dfs(n,0);
			System.out.println(r);
		}
	}

	private static long dfs(int a, int b) {
		if(a < 0 || b < 0) return 0;
		if(dp[a][b]!=-1) return dp[a][b];
		if(a == 0 && b == 0) {
			return 1;
		}else {
			
			return dp[a][b] = dfs(a-1, b+1)+dfs(a,b-1);
		}
		
	}
}
