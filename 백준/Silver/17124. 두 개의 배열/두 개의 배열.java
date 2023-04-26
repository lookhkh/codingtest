import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 
	 * A : 서로 다른 양의 정수 N
	 * B : 서로 다른 양의 정수 M
	 * 
	 * A : 20,5,14,9
	 * B : 8 12 16
	 * 
	 * if(A[i] - B[i] > 0 => 오른쪽으로 이동
	 * 
	 * A[i] = 6,
	 * B = 1,2,3,4 ,7,8,11,12
	 * if(A[i] - B[i] < 0 => 
	 * 
	 * A[i] = 5
	 * B :  1,2, 6, 7, 8, 9
	 * 
	 * A[i]보다 첫 번째로 커지는 값;
	 * A[i]보다 처음으로 작아지는 값;
	 * A[i]와 동일한 값.,
	 * 
	 */
	
	static int defaultValue = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk= new StringTokenizer( br.readLine() ," ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.valueOf(tk.nextToken());
		
		for(int t=0; t<test; t++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.valueOf(tk.nextToken());
			int m = Integer.valueOf(tk.nextToken());
			
			int[] a = new int[n];
			int[] b = new int[m];
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int i=0; i<n; i++) {
				a[i] = Integer.valueOf(tk.nextToken());
			}
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int i=0; i<m; i++) {
				b[i] = Integer.valueOf(tk.nextToken());
			}
			
			Arrays.sort(b);
			
			long result = 0;
			
			for(int i=0; i<a.length; i++) {
				
				int firstLarget = searchFirstLarge(a[i], b);
				int firstSmall = searchFirstSmall(a[i],b);
				
				int firstAbs = Math.abs(firstLarget - a[i]);
				int secondAbs = Math.abs(firstSmall - a[i]);
				
				if(firstAbs == secondAbs) {
					
					if(firstSmall != defaultValue) result+=firstSmall;
					else result+=firstLarget;
					
					
				}else if(firstAbs > secondAbs) {
					result += firstSmall;
				}else {
					result += firstLarget;
				}

			}
			
			bw.append(result+"\n");
			
		}
		
		bw.flush();
		
	}

	private static int searchFirstSmall(int a, int[] b) {
		int left = 0;
		int right = b.length-1;
		int answer = defaultValue;
		while(left <= right) {
			
			int mid = (left + right)/2;
			int midVal = b[mid];
			
			if(a >= midVal) {
				left = mid+1;
				answer = midVal;
			}else if(a <= midVal){
				right = mid-1;
			}
			
			
		}
		
		return answer ;
	}

	private static int searchFirstLarge(int a, int[] b) {
		int left = 0;
		int right = b.length-1;
		int answer =  defaultValue;
		while(left <= right) {
			
			int mid = (left + right)/2;
			int midVal = b[mid];
			
			if(a > midVal) {
				left = mid+1;
			}else if(a <= midVal){
				answer = midVal;
				right = mid-1;
			}
			
			
		}
		
		return answer;
	}
}