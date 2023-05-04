
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int target = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length-1;
		int answer = 0;
		while(left < right) {
			
			int sum = arr[left]+arr[right];
			if(sum >= target) {
				if(sum == target) answer++;
				right --;
				
			}else if(sum < target) {
				left ++;
			}
						
		}
		
		
		System.out.println(answer);
		
	}
}
