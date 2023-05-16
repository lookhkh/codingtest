import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[10_000_001];
				
		for(int i=0; i<arr.length; i++) {
			arr[i] = true;
		}
		
		에라토스네스의체(arr);
		
		
		
		int a = Integer.valueOf(br.readLine());
		if(a == 1) {
			System.out.println();
			return;
		}
		for(int i=2; i<=a; i++) {
			while(arr[i] && a % i == 0) {
				a/=i;
				System.out.println(i);
			}
		}
		
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