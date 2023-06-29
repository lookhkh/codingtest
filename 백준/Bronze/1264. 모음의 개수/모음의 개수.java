import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String i = "";
		
		String regx = "(a|i|e|o|u|I|A|E|O|U)";
		
		while(!(i=br.readLine()).equals("#")) {
			
			i = i.replaceAll(regx, "1");
			int cnt = 0;
			for(int j=0; j<i.length(); j++) {
				if(i.charAt(j) =='1') cnt++;
			}
			
			System.out.println(cnt);
			
		}
	}
}
