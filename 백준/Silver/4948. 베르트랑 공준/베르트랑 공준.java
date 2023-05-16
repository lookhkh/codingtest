import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[10_000_001];
				
		for(int i=0; i<arr.length; i++) {
			arr[i] = true;
		}
		
		에라토스네스의체(arr);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a =-1;
		while((a=Integer.valueOf(br.readLine()))!=0) {
			int cnt = 0;
			for(int i=a+1; i<=2*a; i++) {
				if(arr[i]) cnt++;
			}
			bw.append(cnt+"\n");
			
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
