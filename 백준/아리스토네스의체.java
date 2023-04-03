//https://www.acmicpc.net/problem/2960
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2960 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int k = Integer.valueOf(tk.nextToken());
		
		int cnt = 0;
		
		boolean[] ch = new boolean[n+1];
		
		for(int i=2; i<=n; i++) {
			
			for(int j=1; j*i<=n; j++) {
				
				
				if(!ch[j*i]) {
					ch[j*i] = true;
					cnt++;
				}
				
				if(cnt == k) {
					System.out.println(i*j);
					return;
				}
				
			}
			
		}
		
		
	}
}
