import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		int n= Integer.valueOf(tk.nextToken());
		
		int[] arr = new int[n];
		
		int m= Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		
		int left = 0;
		
		int remain = m;
		
		int cnt = 0;
		
		int max = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			if(isEvenNumber(arr[i])) {
				
				cnt++;
			}else {
				if(remain > 0) {
					remain--;
				}
				else {
					
					while( left < arr.length && remain < 1) {
						
						if(!isEvenNumber(arr[left])) {
							remain++;
						}else {
							cnt--;
						}
						
						left++;
					}
                    
                    remain--;
				}
			}
			
			max = Math.max(max, cnt);
			
		}
		
		System.out.println(max);
	}

	private static boolean isEvenNumber(int i) {

		return i % 2 == 0;
	}
}
