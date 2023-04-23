import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int whole = in.nextInt();
		
		int[] arr = new int[whole];
		
		for(int i=0; i<whole; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			
			sum+=(whole-i) * arr[i];
			
		}
		
		System.out.println(sum);

	}
}