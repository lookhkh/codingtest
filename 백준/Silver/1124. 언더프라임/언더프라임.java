import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		int n = Integer.valueOf(tk.nextToken());
		int m = Integer.valueOf(tk.nextToken());
		
		List<Integer> primes = getPrimes(m);
		int ans = 0;
		for(int i=n; i<=m; i++) {
			
			int next = i;
			int cnt = 0;
			for(int j=0; j<primes.size(); j++) {
				
				int nextPrime = primes.get(j);
				if(next % nextPrime == 0) {
					cnt++;
					next /= nextPrime;
					j--;
				}
				
			}
			
			if(!arr[cnt]) {
				ans++;
			}
		}
		System.out.println(ans);
	
	}

	private static List<Integer> getPrimes(int m) {
		
		List<Integer> list = new ArrayList<>();
		arr = new boolean[m+1];
		arr[1] = true;
		
		for(int i=2; i<=Math.sqrt(m); i++) {
			
			for(int j=i+i; j<=m; j+=i) {
				arr[j] = true;
			}

		}
		
		for(int i=2; i<arr.length; i++) {
			if(!arr[i]) list.add(i); 
		}
		
		return list;
	}
}
