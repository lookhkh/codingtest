import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.valueOf(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<cnt; i++) {
			
			String t= br.readLine();
			boolean r = t.matches("(100+1+|01)+");
			bw.append(r?"YES"+"\n":"NO"+"\n");
			
		}
		
		bw.flush();
	}
}