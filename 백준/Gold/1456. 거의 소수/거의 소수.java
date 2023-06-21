import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] ch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		long a = Long.valueOf(tk.nextToken());
		long b = Long.valueOf(tk.nextToken());
		
				
		ch = new boolean[(int)Math.sqrt(b)+1];
		
		init();
	
		long sum = 0;
		
		for(int i=1; i<ch.length; i++) {
			
			if(ch[i]) continue;
			
			int n =2;
			while(true) {
				
				long next = (long)Math.pow(i, n);
				if(next>=a && next<=b) sum++;
				if(next > b) break;
				n++;
				
			}

		}
		
		System.out.println(sum);
	}

	private static void init() {
		
		int last = ch.length;
		ch[1] = true;
		
		for(int i=2; i<Math.sqrt(last);i++) {
			for(int j=i+i; j<last; j+=i) {
				ch[j] = true;
			}
		}
		
		
	}
}
