import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		arr = new int[n];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			int next = Integer.valueOf(tk.nextToken());
			max = Math.max(max, next);
			arr[i] = next;
		}
		
		m = Integer.valueOf(br.readLine());
		
		int left = 1;
		int right= max;
		int result = 0;
		
		while(left <= right) {
			
			int mid = (left+right)/2;
			if(check(mid)) {
				left = mid+1;
				result = Math.max(result, mid);
			}else {
				right = mid-1;
			}
			
		}
		
		System.out.println(result);
		
	}
	private static boolean check(int mid) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			int n = arr[i];
			if(n <=mid) sum+=n;
			else sum+=mid;
		}
		
		if(sum <= m) return true;
		
		return false;
	}
}
