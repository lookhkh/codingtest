import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static int r;
	static int c;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		r = Integer.valueOf(tk.nextToken());
		c = Integer.valueOf(tk.nextToken());
		

		divide(0,0,(int)Math.pow(2, n), 0 );
	}
	private static void divide(int n, int m, int size, int loc) {
		
		if(size == 2) {
			int cnt = 0;
			for(int i=n; i<n+size; i++) {
				for(int j=m; j<m+size; j++) {
					int result = loc+cnt++;
					if(i == r && c ==j) System.out.println(result);
				}
		}
			
		}else {
			int nextSize = size/2;
			//2사분면
			if(isIncluded(n, m, nextSize)) divide(	n, m,nextSize , 0+loc );
			//1사분면
			if(isIncluded( n, m+nextSize, nextSize)) divide( n, m+nextSize, nextSize, nextSize * nextSize +loc);
			//3사분면
			if(isIncluded( n+nextSize, m, nextSize)) divide(n+nextSize, m, nextSize, nextSize*nextSize * 2+loc);
			//4사분면
			if(isIncluded( n+nextSize, m+nextSize, nextSize)) divide(n+nextSize, m+nextSize, nextSize, nextSize*nextSize * 3+loc);
		}
		
		
	}
	private static boolean isIncluded(int n, int m, int nextSize) {
		return r >= n && r<=n+nextSize && c>=m && c<=m+nextSize;
	}
}
