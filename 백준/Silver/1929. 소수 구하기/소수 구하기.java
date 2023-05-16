import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[1_000_001];
				
		for(int i=0; i<arr.length; i++) {
			arr[i] = true;
		}
		
		에라토스네스의체(arr);
		
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.valueOf(tk.nextToken());
		int b = Integer.valueOf(tk.nextToken());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=a; i<=b; i++) {
			if(arr[i]) bw.append(i+"\n");
		}
		
		bw.flush();
	}

	private static void 에라토스네스의체(boolean[] arr) {
		arr[1] = false;
		for(int i=2; i<arr.length; i++) {
			
			for(int j=i+i; j<arr.length; j+=i) {
				
				arr[j] = false;
				
			}
			
		}
		
	}
}