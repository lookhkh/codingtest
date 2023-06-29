import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String original = br.readLine();
		int originalSize = original.length();
		String target = br.readLine();
		
		original = original.replaceAll(target, "");
		
		System.out.println( (originalSize - original.length()) / target.length());

	}
}