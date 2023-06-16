import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		arr = new boolean[t+1];
		
		init(t);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int next=7; next<=t; next++) {
			
			if(arr[next]) continue;
			if(!isSanGeunSu(next)) continue;
			bw.append(next+"\n");

		}
		bw.flush();
	}
	private static boolean isSanGeunSu(long next) {
		Set<Long> set = new HashSet<>();
		
		while(true) {
			
			long result = 0;
			int r = 10;
			
			while(next > 0) {
				
				long n = next % r;
				result+= Math.pow(n, 2);
				next = next / r;
				
			}
			//System.out.println(result+" "+set);
			if(result == 1) return true;
			if(set.contains(result)) return false;
			
			set.add(result);
			next = result;
		}
	}
	private static void init(int t) {
		arr[0] = true;
		arr[1] = true;
		for(int i=2; i<=Math.sqrt(t); i++) {
			for(int j=i+i; j<=t; j+=i) {
				arr[j] = true;
			}

		}
	
		
	}
}