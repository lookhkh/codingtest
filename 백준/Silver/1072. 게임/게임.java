import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		long x = Integer.valueOf(tk.nextToken());
		long y = Integer.valueOf(tk.nextToken());
		
		if(x == y) {
			System.out.println(-1);
			return;
		}
		
		long original = (y * 100) / x;

		long left = 1;
		long right = 1_000_000_000;
		long answer = -1;
		
		while(left <= right) {
			
			long mid = (left + right) / 2;
			long changeY = (y+mid);
			long changeX = (x+mid);
			
			long rate = (changeY * 100 / changeX);
			
			if(rate > original) {
				answer = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
			
		}
		
		System.out.println(answer);
	}

}