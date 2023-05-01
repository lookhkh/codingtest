import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr = new int[27];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		
		
		for(char n : in.toCharArray()) {

			arr[getIdx(n)] += 1;
			
		}
				
		if(cntIfElementIsOnelyOne() > 1 || cntIfOddNumbers() > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
	
		
		char[] result = new char[getWholeLength()];
		
		
		int left = 0;
		int right = result.length-1;
		
		for(int i=0; i<arr.length; i++) {
			
			int next = arr[i];
			if(next  == 0) continue;
			
			char temp = getReverseChar(i);

			if(next % 2 != 0) {
				next--;
				int mid = (left + right) / 2;
				result[mid] =temp;
			}
			
			while(next > 0) {
				
				result[left] = temp;
				result[right]= temp;
				
				next -= 2;
				left ++;
				right--;
				
			}

		}
		
		System.out.println(new String(result));
		
	}
	private static char getReverseChar(int i) {
		return (char) ((char) i+'A');
	}
	private static int getIdx(char n) {
		return n-'A';
	}
	
	private static int getWholeLength() {
		
		int cnt = 0;
		
		for(int t : arr) {
			if(t!=0) cnt+=t;
		}
		return cnt;
		
	}
	
	private static int cntIfOddNumbers() {
		int cntOfOne = 0;
		
		for(int t : arr) {
			if(t % 2 != 0) cntOfOne++;
		}
		return cntOfOne;
	}
	private static int cntIfElementIsOnelyOne() {
		int cntOfOne = 0;
		
		for(int t : arr) {
			if(t == 1) cntOfOne++;
		}
		return cntOfOne;
	}

}