
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	
	static int[] arr;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());

		tk = new StringTokenizer(br.readLine()," ");
		
		arr = new int[n];
		
		for(int i=0;i<arr.length; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		Arrays.sort(arr);
		
//		for(int i=0; i<arr.length; i++) {
//			dfs(0, 0, new int[m]);
//		}
		dfs(0, 0, new int[m]);

	}
	private static void dfs(int startIdx, int current , int[] result) throws IOException {
		
		if(current == m) {
			
			StringBuilder b= new StringBuilder();
			for(int r : result) {
				b.append(r);
				b.append(" ");
			}
			
			System.out.println(b.toString());

		}else {
			
			for(int i=startIdx; i<arr.length; i++) {
				
				if(current >0 && result[current-1] > arr[i]) continue;
				result[current] = arr[i];
				dfs(startIdx, current+1, result);

			}
			
		}
		
	}
}
