
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		
		double[] arr = new double[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Double.valueOf(tk.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		double[] lastPositon = null;
		int answer = 0;
		for(int i=0; i<arr.length; i++) {
			
			double next = arr[i];
			
			if(lastPositon == null ) {
				lastPositon = new double[] {next-0.5 , next - 0.5 + m * 1.0};
				answer++;
			}else {
				
				if(next-0.5 >= lastPositon[0] && next+0.5 <=lastPositon[1] ) {
					
				}else {
					
					lastPositon = new double[] {next-0.5 , next - 0.5 + m * 1.0};
					answer++;
					
				}
				
			}
			
		}
		
		System.out.println(answer);
		
		
	}
}
