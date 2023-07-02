import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		
		int answer = 0;
		while(Integer.bitCount(n)>m) {
			n+=1;
			answer+=1;
		}
		
		System.out.println(answer);
		
	}
}
