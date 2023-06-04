import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.valueOf(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			String first = tk.nextToken();
			int[] firstone = convert(first);
			
			String second = tk.nextToken();
			int[] seoncOne = convert(second);
			
			boolean result = true;
			for(int z=0; z<firstone.length; z++) {
				if(firstone[z] != seoncOne[z]) {
					System.out.println(first+" & "+second+" are NOT anagrams.");
					result = false;
					break;
				}
			}
			
			if(result) 	System.out.println(first+" & "+second+" are anagrams.");

			
		}
	}
	
	public static int[] convert(String t) {
		int[] r = new int[26];
		for(int i=0; i<t.length(); i++) {
			r[t.charAt(i)-'a'] +=1;
		}
		return r;
		
	}
}