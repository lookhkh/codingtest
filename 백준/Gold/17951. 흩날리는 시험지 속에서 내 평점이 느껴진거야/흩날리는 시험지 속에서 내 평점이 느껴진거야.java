import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int k;
	static int[] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n =Integer.valueOf(tk.nextToken());
		k =Integer.valueOf(tk.nextToken());
		
		sum = new int[n];
		tk = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<n; i++) {
			if(i == 0) sum[i] = Integer.valueOf(tk.nextToken());
			else {
				sum[i] = sum[i-1]+Integer.valueOf(tk.nextToken());
			}
		}
		
		int left = 0;
		int right = Integer.MAX_VALUE;
		int answer = 0;
		while(left <= right) {
			
			int mid = (left + right)/2;
			if(check(mid)>=k) {
				left = mid+1;
				answer = Math.max(answer, mid);
			}else {
				right = mid-1;
			}
		}
		
		System.out.println(answer);
	}
	private static int check(int mid) {
		
		int cnt = 0;
		int left = -1;
		
		if(sum[0] >= mid) {
			cnt ++;
			left = 0;
		}
		
		for(int i=1; i<sum.length; i++) {
			
			if(left == -1) {
				if(sum[i] >= mid) {
					cnt++;
					left = i;
				}
			}else {
				if(sum[i] - sum[left] >=mid) {
					cnt++;
					left= i;
				}
			}
	
			
		}

		
		return cnt;
	}
}