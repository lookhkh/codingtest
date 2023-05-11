import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
	
		Arrays.sort(arr);
		
		long sum = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			
			int left = i+1;
			int right = arr.length-1;
			
			while(left <= right) {
				
				int mid = (left+right)/ 2;
				
				double curVal = arr[i]*1.0;
				double targetVal = ( arr[mid]*1.0 ) * 0.9;
				
				if(curVal >= targetVal) {
					left = mid+1;
				}else {
					right = mid-1;
				}
				
			}
			
			sum+=right - i;
			
			
		}
		
		System.out.println(sum);
		
		
	}
}