import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		BigInteger[][] arr = new BigInteger[n+1][n+1];
		
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i == j) arr[i][j] = BigInteger.ONE;
				else if(j == 0) arr[i][j] = BigInteger.ONE;
				else if( j == 1) arr[i][j] = BigInteger.valueOf(i);
				
			}
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				
			if(i-1 >=j)	arr[i][j] = arr[i-1][j].add(arr[i-1][j-1]);
			
			}
		}
		
		System.out.println(arr[n][m]);

	}
}
