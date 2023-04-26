import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t= br.readLine();
		
		String[] sub = new String[t.length()];
		
		for(int i=t.length()-1; i>=0; i--) {
			String subStr = t.substring(i);
			sub[i] = subStr;
		}
		
		Arrays.sort(sub);
		
		for(String w: sub) System.out.println(w);
		
	}
}
