import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		char[] l = new StringBuilder(tk.nextToken()).toString().toCharArray();
		char[] r = new StringBuilder(tk.nextToken()).toString().toCharArray();
		
		int answer = 0;
        if(l.length != r.length) {
			System.out.println(0);
			return;
		}
		for(int i=0; i<l.length && i<r.length; i++) {
			
			char left = l[i];
			char right = r[i];
			
		
			if(left == right) {
				if(left =='8') answer++;
			}
			else break;
		}
		System.out.println(answer);
		
			
		}
	
}