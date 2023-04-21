import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			int t  = Integer.valueOf(tk.nextToken());
			arr[i] = t;
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			if(i == 0) sum[i] = arr[i];
			else sum[i]= sum[i-1]+arr[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<m; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int left = Integer.valueOf(tk.nextToken());
			int right = Integer.valueOf(tk.nextToken());
			
			int result = sum[right] - sum[left-1];
			bw.append(result+"\n");

		}		
		
		bw.flush();
	}
}
