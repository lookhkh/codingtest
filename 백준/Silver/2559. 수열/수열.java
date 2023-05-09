import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken()); 
		}
		
		int sum = 0;
		
		for(int i=0; i<m; i++) {
			sum+=arr[i];
		}
		int max = sum;

		int left = 0;
		for(int i=m; i<n; i++) {
			sum = sum - arr[left++]+arr[i];
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
		
	}
}
