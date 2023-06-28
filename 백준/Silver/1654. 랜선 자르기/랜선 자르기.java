import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		arr = new long[n];
		
		long max = 0;
		for(int i=0; i<n; i++) {
			long next = Long.valueOf(br.readLine());
			arr[i] = next;
			max = Math.max(max, next);
		}
		
		long left = 1;
		long right = max;
	
		long answer = 0;
		while(left <= right) {
			
			long mid = (left+right)/2;
			if(check(mid,m)) {
				answer = Math.max(mid, answer);
				left = mid+1;
			}else {
				right = mid-1;
			}
			
		}
		
		System.out.println(answer);
		
	}

	private static boolean check(long mid, long target) {
		
		long cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			long next = arr[i];
			cnt+= next/mid;
			if(cnt >= target) return true;
		}
		
		return false;
	}
}