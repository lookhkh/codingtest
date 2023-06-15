import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		long left = 1;
		long right = 1000000000000L;
		
		long answer = Long.MAX_VALUE;
		while(left <= right) {
			
			long mid = (left+right)/2;
			
			if(count(mid,m)) {
				right = mid-1;
				answer = Math.min(answer, mid);
			}else {
				left = mid+1;
			}
			
		}
		System.out.println(answer);
	}

	private static boolean count(long mid, int m) {

		long cnt = 0;
		for(int i=0; i<arr.length; i++) {
			
			cnt += mid / arr[i];
			if(cnt >= m) return true;
			
		}
		
		
		return false;
	}
}
