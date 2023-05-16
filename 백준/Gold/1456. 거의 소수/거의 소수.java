
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		long a = Long.valueOf(tk.nextToken());
		long b = Long.valueOf(tk.nextToken());
		
		boolean[] arr = new boolean[(int)Math.sqrt(b)+1];
		
		Arrays.fill(arr, true);
		
	
		아르티네스의체(arr);
		long cnt = 0;
		for(int i=2; i<arr.length; i++) {
			
			if(!arr[i]) continue;
			
			int n = 2;
			while(true) {
				
				long temp = (long) Math.pow(i, n++);
				if(temp >=a && temp <= b) cnt++;
				if(temp > b) break;
			}

			
		}
		
		System.out.println(cnt);
		
	}

	private static void 아르티네스의체(boolean[] arr) {
		
		arr[1] = false;
		
		for(int i=2; i<arr.length; i++) {
			for(int j=i+i; j<arr.length; j+=i) {
				if(!arr[j]) continue;
				arr[j] = false;
			}
		}
		
	}
}
